package org.thegenealogyproject.api.validation;

import org.thegenealogyproject.api.dto.CreatePhotoDto;

public interface FileValidator {
    void validate(CreatePhotoDto photo);
}
