package com.github.jbence1994.genealogy.validation;

import com.github.jbence1994.genealogy.config.FileExtensionsConfig;
import com.github.jbence1994.genealogy.dto.CreatePhotoDto;
import com.github.jbence1994.genealogy.exception.EmptyFileException;
import com.github.jbence1994.genealogy.exception.InvalidFileExtensionException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
