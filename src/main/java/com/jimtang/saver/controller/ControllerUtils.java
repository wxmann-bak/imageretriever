package com.jimtang.saver.controller;

import com.jimtang.saver.imagesav.ImageSaver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangz on 8/29/2015.
 */
public final class ControllerUtils {

    private ControllerUtils() {}

    public static void addLocationsFromMap(ImageSaver saver, Map<String, String> locationMap) {
        for (String sourceLoc: locationMap.keySet()) {
            String targetLoc = locationMap.get(sourceLoc);
            saver.addLocation(sourceLoc, targetLoc);
        }
    }

    public static TimeUnit getTimeUnitFromString(String timeUnitString) {
        switch(timeUnitString.toUpperCase()) {
            case "HOURS":
                return TimeUnit.HOURS;
            case "MINUTES":
                return TimeUnit.MINUTES;
            case "DAYS":
                return TimeUnit.DAYS;
            default:
                throw new RuntimeException("Invalid time unit string: " + timeUnitString);
        }
    }
}
