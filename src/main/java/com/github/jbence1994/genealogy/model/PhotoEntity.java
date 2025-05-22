package com.github.jbence1994.genealogy.model;

import org.springframework.util.StringUtils;

public abstract class PhotoEntity {
    public abstract String getPhotoFileName();

    public abstract void setPhotoFileName(String photoFileName);

    public boolean hasPhoto() {
        return getPhotoFileName() != null;
    }

    public String getPhotoFileExtension() {
        return StringUtils.getFilenameExtension(getPhotoFileName());
    }
}
