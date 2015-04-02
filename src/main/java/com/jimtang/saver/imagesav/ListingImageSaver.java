package com.jimtang.saver.imagesav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by tangz on 4/1/2015.
 */
public class ListingImageSaver extends PageImageSaver {

    private static final Logger LOGGER = Logger.getLogger(ListingImageSaver.class.getName());

    private WebDriver webDriver;

    public ListingImageSaver() {
        super();
        webDriver = new HtmlUnitDriver();
    }

    protected Collection<String> findImages(String srcLocation) {
        webDriver.get(srcLocation);
        List<WebElement> links = webDriver.findElements(By.tagName("a"));
        LOGGER.info(String.format("Found %s links in %s", links.size(), srcLocation));
        return links.stream()
                .map(link -> link.getAttribute("href"))
                .collect(Collectors.toList());
    }
}
