package com.github.jbence1994.genealogy.mapper;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface MultipartFileToCreatePhotoDtoMapper<Dto> {
    Dto toDto(UUID id, MultipartFile file);
}
