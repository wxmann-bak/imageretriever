package com.jimtang.saver.imagesav;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by tangz on 3/31/2015.
 */
public abstract class PageImageSaver implements ImageSaver {

    private static final Logger LOGGER = Logger.getLogger(PageImageSaver.class.getName());

    SimpleImageSaver directImageSaver;
    Map<String, String> locationMapping;
    Predicate<String> additionalFilter;
    String[] fileTypes;

    public PageImageSaver() {
        directImageSaver = new SimpleImageSaver();
        locationMapping = Maps.newHashMap();
        additionalFilter = link -> true;
    }

    protected Predicate<String> fileTypeMatchFilter() {
        if (fileTypes.length == 0) {
            return link -> true;
        }
        String fileTypeMatch = String.format("(%s)", StringUtils.join(fileTypes, "|"));
        String initialLinkCharacters = ".+?";
        String caseInsensitivity = "(?i)";
        String regex = caseInsensitivity + initialLinkCharacters + fileTypeMatch;

        return link -> link.matches(regex);
    }

    public void setFileTypes(String... fileTypes) {
        this.fileTypes = fileTypes;
    }

    public void setAdditionalFilter(Predicate<String> filter) {
        this.additionalFilter = filter;
    }

    public void addLocation(String pageUrl, String localDirectory) {
        locationMapping.put(pageUrl, localDirectory);
    }

    protected String fileDepositLocation(String fileUrl, String pageUrl, String targetDirectory) {
        try {
            URI fileUri = new URI(fileUrl);
            URI relativeUri = new URI(pageUrl).relativize(fileUri);
            String depositLocation = "";
            if (targetDirectory.endsWith("/") || targetDirectory.endsWith("\\")) {
                depositLocation = targetDirectory + relativeUri.toString();
            } else {
                depositLocation = targetDirectory + "/" + relativeUri.toString();
            }
            LOGGER.info(String.format("File from: %s to be deposited in: %s", fileUrl, depositLocation));
            return depositLocation;
        } catch (URISyntaxException e) {
            throw new UnsupportedUrlException(e);
        }
    }

    protected Collection<String> filterImages(Collection<String> foundImages) {
        Collection<String> filtered = foundImages.stream()
                .filter(fileTypeMatchFilter())
                .filter(additionalFilter)
                .collect(Collectors.toList());
        LOGGER.info(String.format
                ("Number of files to save filtered down to: %s by matching file types: %s and supplied filter", filtered.size(), fileTypes.length == 0 ? "all" : Arrays.toString(fileTypes)));
        return filtered;
    }

    protected abstract Collection<String> findImages(String pageUrl);

    @Override
    public void execute() {
        for (Map.Entry<String, String> entry : locationMapping.entrySet()) {
            String pageUrl = entry.getKey();
            String targetDirectory = entry.getValue();
            Collection<String> linkUrls = filterImages(findImages(pageUrl));
            for (String fileUrl : linkUrls) {
                String targetLocation = fileDepositLocation(fileUrl, pageUrl, targetDirectory);
                directImageSaver.addLocation(fileUrl, targetLocation);
            }
        }
        directImageSaver.execute();
    }
}
