package com.jimtang.saver.imagesav;

import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Created by tangz on 3/31/2015.
 */
public class DirectoryImageSaver implements ImageSaver {

    private WebDriver webDriver;
    private SimpleImageSaver directImageSaver;
    private Map<String, String> directoryMapping;

    public DirectoryImageSaver() {
        
    }

    @Override
    public void execute() {

    }
}
