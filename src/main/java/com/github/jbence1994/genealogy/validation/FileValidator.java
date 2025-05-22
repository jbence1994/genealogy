package com.github.jbence1994.genealogy.validation;

import com.github.jbence1994.genealogy.dto.CreatePhotoDto;

public interface FileValidator {
    void validate(CreatePhotoDto photo);
}
