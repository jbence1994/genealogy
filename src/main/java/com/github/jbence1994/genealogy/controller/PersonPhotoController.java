package com.github.jbence1994.genealogy.controller;

import com.github.jbence1994.genealogy.dto.CreatePersonPhotoDto;
import com.github.jbence1994.genealogy.dto.PersonPhotoDto;
import com.github.jbence1994.genealogy.dto.PhotoResponse;
import com.github.jbence1994.genealogy.exception.EmptyFileException;
import com.github.jbence1994.genealogy.exception.InvalidFileExtensionException;
import com.github.jbence1994.genealogy.exception.PersonAlreadyHasAPhotoUploadedException;
import com.github.jbence1994.genealogy.exception.PersonDoesNotHaveAPhotoUploadedYetException;
import com.github.jbence1994.genealogy.exception.PersonNotFoundException;
import com.github.jbence1994.genealogy.exception.PersonPhotoDeleteException;
import com.github.jbence1994.genealogy.exception.PersonPhotoDownloadException;
import com.github.jbence1994.genealogy.exception.PersonPhotoNotFoundException;
import com.github.jbence1994.genealogy.exception.PersonPhotoUploadException;
import com.github.jbence1994.genealogy.mapper.MultipartFileToCreatePhotoDtoMapper;
import com.github.jbence1994.genealogy.model.Person;
import com.github.jbence1994.genealogy.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/person/{id}/photo")
@CrossOrigin
@AllArgsConstructor
public class PersonPhotoController {
    private final PhotoService<CreatePersonPhotoDto, PersonPhotoDto, Person> photoService;
    private final MultipartFileToCreatePhotoDtoMapper<CreatePersonPhotoDto> toCreatePhotoDtoMapper;

    @PostMapping
    public ResponseEntity<?> uploadPersonPhoto(
            @PathVariable UUID id,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            var photoDto = toCreatePhotoDtoMapper.toDto(id, file);

            var photoFileName = photoService.uploadPhoto(photoDto);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new PhotoResponse(photoFileName));
        } catch (PersonNotFoundException exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        } catch (
                EmptyFileException |
                InvalidFileExtensionException |
                PersonAlreadyHasAPhotoUploadedException exception
        ) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        } catch (PersonPhotoUploadException exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getPersonPhoto(@PathVariable UUID id) {
        try {
            var photo = photoService.getPhoto(id);

            var headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(String.format("image/%s", photo.getFileExtension())));

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .body(photo.getPhotoBytes());
        } catch (
                PersonNotFoundException |
                PersonPhotoNotFoundException exception
        ) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        } catch (PersonPhotoDownloadException exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletePersonPhoto(@PathVariable UUID id) {
        try {
            photoService.deletePhoto(id);

            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (PersonDoesNotHaveAPhotoUploadedYetException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        } catch (PersonPhotoDeleteException exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }
    }
}
