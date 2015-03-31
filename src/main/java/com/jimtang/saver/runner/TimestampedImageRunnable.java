package com.jimtang.saver.runner;

import com.jimtang.saver.file.TimestampAppender;

/**
 * Created by tangz on 3/30/2015.
 */
public class TimestampedImageRunnable extends SaveImageRunnable {

    public TimestampedImageRunnable(String imageUrl, String locationToSave) {
        super(imageUrl, locationToSave);
    }

    @Override
    protected String processSaveLocation(String locationToSave) {
        return new TimestampAppender("yyyyMMdd_HHmmss", "UTC").buildName(locationToSave);
    }
}
