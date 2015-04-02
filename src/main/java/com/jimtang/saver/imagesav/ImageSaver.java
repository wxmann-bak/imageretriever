package com.jimtang.saver.imagesav;

/**
 * Created by tangz on 3/30/2015.
 */
public interface ImageSaver {

    void addLocation(String onlineLocation, String machineLocation);

    void execute();
}
