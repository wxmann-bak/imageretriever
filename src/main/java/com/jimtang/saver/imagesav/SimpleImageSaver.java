package com.jimtang.saver.imagesav;

import com.jimtang.saver.runner.SaveImageRunnable;
import com.jimtang.saver.runner.TimestampedImageRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by tangz on 3/31/2015.
 */
public class SimpleImageSaver implements ImageSaver {

    private ExecutorService service;
    Map<String, String> imageToSaveLocationMap = new HashMap<String, String>();

    public void addLocation(String imageUrl, String locationToSave) {
        if (imageUrl == null || locationToSave == null) {
            throw new ImageRetrievalException("Image url and location to save cannot be null!");
        }
        imageToSaveLocationMap.put(imageUrl, locationToSave);
    }

    @Override
    public void execute() {
        service = Executors.newFixedThreadPool(1);
        for (Map.Entry<String, String> imageToSaveMapEntry : imageToSaveLocationMap.entrySet()) {
            String imageUrl = imageToSaveMapEntry.getKey();
            String fileLocationToSave = imageToSaveMapEntry.getValue();
            service.execute(new SaveImageRunnable(imageUrl, fileLocationToSave));
        }
        service.shutdown();
    }
}
