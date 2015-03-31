package com.jimtang.saver.runner;

import com.jimtang.saver.imagesav.ImageRetrievalException;

import java.io.*;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by tangz on 3/30/2015.
 */
public class SaveImageRunnable implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(SaveImageRunnable.class.getName());

    public static final int DEFAULT_BYTES = 3000;

    private String imageUrl;
    private String locationToSave;
    private int bytes = DEFAULT_BYTES;

    public SaveImageRunnable(String imageUrl, String locationToSave) {
        this.imageUrl = imageUrl;
        this.locationToSave = locationToSave;
    }

    public void setCapacity(int bytes) {
        this.bytes = bytes;
    }

    protected String processSaveLocation(String locationToSave) {
        return locationToSave;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String actualLocationToSave = processSaveLocation(locationToSave);
            URL url = new URL(imageUrl);
            inputStream = url.openStream();
            outputStream = new FileOutputStream(actualLocationToSave);

            byte[] byteArray = new byte[bytes];
            int len;
            while ((len = inputStream.read(byteArray)) != -1) {
                outputStream.write(byteArray, 0, len);
            }
            LOGGER.info(String.format("Wrote file from: %s, to: %s", imageUrl, actualLocationToSave));
        } catch (IOException e) {
            throw new ImageRetrievalException(e);
        } finally {
            try {
                if (inputStream != null)  inputStream.close();
                if (outputStream != null)   outputStream.close();
            } catch (IOException e) {
                LOGGER.severe("Issue in closing stream resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
