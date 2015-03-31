package com.jimtang.saver;

import com.jimtang.saver.imagesav.RecurringImageSaver;
import com.jimtang.saver.imagesav.SimpleImageSaver;

import java.util.concurrent.TimeUnit;

public class ImageRetrieverApp {

    public static void main(String[] args) {

        SimpleImageSaver simpleSaver = new SimpleImageSaver();

        int period1 = 30;
        TimeUnit periodTimeUnit1 = TimeUnit.MINUTES;
        RecurringImageSaver saverSingle = new RecurringImageSaver(period1, periodTimeUnit1);

        int period2 = 6;
        TimeUnit periodTimeUnit2 = TimeUnit.HOURS;
        RecurringImageSaver saverLoop = new RecurringImageSaver(period2, periodTimeUnit2);

        String imageUrlAvnSingle = "http://www.ssd.noaa.gov/PS/TROP/floaters/04W/imagery/avn0.gif";
        String locationToSaveAvnSingle = "C:\\Dev\\saveImageTest\\AVN_single.gif";
        saverSingle.addImage(imageUrlAvnSingle, locationToSaveAvnSingle);

        String imageUrlAvnLoop = "http://www.ssd.noaa.gov/PS/TROP/floaters/04W/imagery/avn-animated.gif";
        String locationToSaveAvnLoop = "C:\\Dev\\saveImageTest\\AVN_loop.gif";
        saverLoop.addImage(imageUrlAvnLoop, locationToSaveAvnLoop);

        String imageUrlRgbSingle = "http://www.ssd.noaa.gov/PS/TROP/floaters/04W/imagery/rgb0.gif";
        String locationToSaveRgbSingle = "C:\\Dev\\saveImageTest\\RGB_single.gif";
        saverSingle.addImage(imageUrlRgbSingle, locationToSaveRgbSingle);

        String imageUrlRgbLoop = "http://www.ssd.noaa.gov/PS/TROP/floaters/04W/imagery/rgb-animated.gif";
        String locationToSaveRgbLoop = "C:\\Dev\\saveImageTest\\RGB_loop.gif";
        saverLoop.addImage(imageUrlRgbLoop, locationToSaveRgbLoop);

        simpleSaver.addImage(imageUrlRgbLoop, locationToSaveRgbLoop);

        saverSingle.execute();
        saverLoop.execute();
        //simpleSaver.execute();
    }
}
