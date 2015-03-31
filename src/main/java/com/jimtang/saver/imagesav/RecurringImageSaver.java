package com.jimtang.saver.imagesav;

import com.jimtang.saver.runner.TimestampedImageRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangz on 3/30/2015.
 */
public class RecurringImageSaver extends SimpleImageSaver implements ImageSaver {

    private ScheduledExecutorService executorService;
    private int period;
    private TimeUnit periodTimeUnit;

    public RecurringImageSaver(int period, TimeUnit timeUnit) {
        super();
        this.executorService = Executors.newScheduledThreadPool(1);
        this.period = period;
        this.periodTimeUnit = timeUnit;
    }

    @Override
    public void execute() {
        long initialDelay = 0L;
        for (Map.Entry<String, String> imageToSaveMapEntry : imageToSaveLocationMap.entrySet()) {
            String imageUrl = imageToSaveMapEntry.getKey();
            String fileLocationToSave = imageToSaveMapEntry.getValue();
            executorService.scheduleAtFixedRate(new TimestampedImageRunnable(imageUrl, fileLocationToSave), initialDelay, period, periodTimeUnit);
        }
    }
}
