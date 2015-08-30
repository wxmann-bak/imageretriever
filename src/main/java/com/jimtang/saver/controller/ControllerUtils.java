package com.jimtang.saver.controller;

import com.jimtang.saver.imagesav.ImageSaver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangz on 8/29/2015.
 */
public final class ControllerUtils {

    public static final String[] VALID_TIME_STRINGS = {"HOURS", "MINUTES", "DAYS", "SECONDS"};
    static final Map<String, TimeUnit> TIME_UNIT_MAP;
    static {
        TIME_UNIT_MAP = new HashMap<>();
        TIME_UNIT_MAP.put(VALID_TIME_STRINGS[0], TimeUnit.HOURS);
        TIME_UNIT_MAP.put(VALID_TIME_STRINGS[1], TimeUnit.MINUTES);
        TIME_UNIT_MAP.put(VALID_TIME_STRINGS[2], TimeUnit.DAYS);
        TIME_UNIT_MAP.put(VALID_TIME_STRINGS[3], TimeUnit.SECONDS);
    }

    private ControllerUtils() {}

    public static void addLocationsFromMap(ImageSaver saver, Map<String, String> locationMap) {
        for (String sourceLoc: locationMap.keySet()) {
            String targetLoc = locationMap.get(sourceLoc);
            saver.addLocation(sourceLoc, targetLoc);
        }
    }

    public static TimeUnit getTimeUnitFromString(String timeUnitString) {
        if (!TIME_UNIT_MAP.containsKey(timeUnitString.toUpperCase())) {
            throw new RuntimeException("Invalid time unit string: " + timeUnitString);
        }
        return TIME_UNIT_MAP.get(timeUnitString.toUpperCase());
    }
}
