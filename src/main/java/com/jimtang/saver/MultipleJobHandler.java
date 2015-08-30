package com.jimtang.saver;

import com.jimtang.saver.imagesav.ImageSaver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Created by tangz on 8/17/2015.
 */
public class MultipleJobHandler {

    private static final Logger LOGGER = Logger.getLogger(MultipleJobHandler.class.getName());

    private Collection<ImageSaver> savers;

    public MultipleJobHandler() {
        savers = new ArrayList<>();
    }

    public void addJob(ImageSaver saver) {
        savers.add(saver);
    }

    public void runAll() {
        if (savers.isEmpty()) {
            LOGGER.info("No image savers in this job handler. Exit.");
            return;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(savers.size());
        for (ImageSaver saver: savers) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    saver.execute();
                }
            });
        }
        executorService.shutdown();
    }
}
