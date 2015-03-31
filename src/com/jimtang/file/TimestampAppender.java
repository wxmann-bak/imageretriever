package com.jimtang.file;

import com.jimtang.file.FileNameBuildException;
import com.jimtang.file.FileNameBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by tangz on 3/30/2015.
 */
public class TimestampAppender implements FileNameBuilder {

    private DateFormat dateFormat;

    public TimestampAppender(String dateFormatStr, String timeZoneStr) {
        dateFormat = new SimpleDateFormat(dateFormatStr);
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneStr));
    }

    private String getTimeStamp() {
        return dateFormat.format(new Date());
    }

    @Override
    public String buildName(String rawFileName) {
        String[] fileParts = rawFileName.split("\\.");
        if (fileParts.length != 2) {
            throw new FileNameBuildException("File name: " + rawFileName + " is not in the expected format: <raw file name>.<file extension>");
        }
        return String.format("%s-%s.%s", fileParts[0], getTimeStamp(), fileParts[1]);
    }

    @Override
    public String buildName(String rawFileName, String fileExtension) {
        String[] fileParts = rawFileName.split("\\.");
        return String.format("%s-%s.%s", fileParts[0], getTimeStamp(), fileExtension);
    }
}
