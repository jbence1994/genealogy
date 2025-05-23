package org.thegenealogyproject.api.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.thegenealogyproject.api.config.FileExtensionsConfig;
import org.thegenealogyproject.api.dto.CreatePhotoDto;
import org.thegenealogyproject.api.exception.EmptyFileException;
import org.thegenealogyproject.api.exception.InvalidFileExtensionException;

@Component
@AllArgsConstructor
public class FileValidatorImpl implements FileValidator {
    private final FileExtensionsConfig fileExtensionsConfig;

    @Override
    public void validate(CreatePhotoDto photo) {
        if (photo.isEmpty()) {
            throw new EmptyFileException(photo.getOriginalFilename());
        }

        var fileExtension = photo.getFileExtension();

        if (!isValid(fileExtension)) {
            throw new InvalidFileExtensionException(fileExtension);
        }
    }

    private boolean isValid(String fileExtension) {
        return fileExtensionsConfig.getAllowedFileExtensions()
                .stream()
                .anyMatch(extension -> extension.equals(fileExtension));

    }
}
