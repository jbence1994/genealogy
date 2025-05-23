package org.thegenealogyproject.api.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.thegenealogyproject.api.dto.CreatePersonPhotoDto;
import org.thegenealogyproject.api.exception.PersonPhotoUploadException;

import java.io.IOException;
import java.util.UUID;

@Component
public class MultipartFileToCreatePersonPhotoDtoMapper implements MultipartFileToCreatePhotoDtoMapper<CreatePersonPhotoDto> {

    @Override
    public CreatePersonPhotoDto toDto(UUID personId, MultipartFile file) {
        try {
            return new CreatePersonPhotoDto(
                    personId,
                    file.isEmpty(),
                    file.getOriginalFilename(),
                    file.getSize(),
                    file.getContentType(),
                    file.getBytes()
            );
        } catch (IOException exception) {
            throw new PersonPhotoUploadException(personId);
        }
    }
}
