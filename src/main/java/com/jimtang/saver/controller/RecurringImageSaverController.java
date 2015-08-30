package com.jimtang.saver.controller;

import com.jimtang.saver.imagesav.ImageSaver;
import com.jimtang.saver.imagesav.RecurringImageSaver;

import java.util.concurrent.TimeUnit;

/**
 * Created by tangz on 8/29/2015.
 */
public class RecurringImageSaverController extends ImageSaverController {

    private String timeUnitString;
    private int timeNumericValue;


    @Override
    protected ImageSaver getImageSaver() {
        TimeUnit timeUnit = ControllerUtils.getTimeUnitFromString(timeUnitString);
        int period = timeNumericValue;
        RecurringImageSaver saver = new RecurringImageSaver(period, timeUnit);
        ControllerUtils.addLocationsFromMap(saver, sourceTargetMapping);
        return saver;
    }

    public void setTimeUnit(String timeUnitString) {
        this.timeUnitString = timeUnitString;
    }

    public void setTimeNumericValue(int timeNumericValue) {
        this.timeNumericValue = timeNumericValue;
    }
}
