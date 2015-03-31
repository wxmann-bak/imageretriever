package com.jimtang.imagesav;

import com.jimtang.runner.TimestampedImageRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangz on 3/30/2015.
 */
public class RecurringImageSaver implements ImageSaver {

    private Map<String, String> imageToSaveLocationMap;
    private ScheduledExecutorService executorService;
    private int period;
    private TimeUnit periodTimeUnit;

    public RecurringImageSaver(int period, TimeUnit timeUnit) {
        imageToSaveLocationMap = new HashMap<String, String>();
        executorService = Executors.newScheduledThreadPool(1);
        this.period = period;
        this.periodTimeUnit = timeUnit;
    }

    public void addImage(String imageUrl, String locationToSavePrefix) {
        if (imageUrl == null || locationToSavePrefix == null) {
            throw new ImageRetrievalException("Image url and location to save cannot be null!");
        }
        imageToSaveLocationMap.put(imageUrl, locationToSavePrefix);
    }

    public void execute() {
        long initialDelay = 0L;
        for (Map.Entry<String, String> imageToSaveMapEntry : imageToSaveLocationMap.entrySet()) {
            String imageUrl = imageToSaveMapEntry.getKey();
            String fileLocationToSave = imageToSaveMapEntry.getValue();
            executorService.scheduleAtFixedRate(new TimestampedImageRunnable(imageUrl, fileLocationToSave), initialDelay, period, periodTimeUnit);
        }
    }
}
