package com.jimtang.saver.controller;

import com.jimtang.saver.imagesav.ImageSaver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangz on 8/29/2015.
 */
public abstract class ImageSaverController{

    Map<String, String> sourceTargetMapping = new HashMap<>();

    protected abstract ImageSaver getImageSaver();

    public void addLocations(String imageSource, String imageTarget) {
        sourceTargetMapping.put(imageSource, imageTarget);
    }

    public void kickoff() {
        getImageSaver().execute();
    }
}
