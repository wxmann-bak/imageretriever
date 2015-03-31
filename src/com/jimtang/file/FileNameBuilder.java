package com.jimtang.file;

/**
 * Created by tangz on 3/30/2015.
 */
public interface FileNameBuilder {

    public String buildName(String rawFileName);

    public String buildName(String rawFileName, String fileExtension);
}
