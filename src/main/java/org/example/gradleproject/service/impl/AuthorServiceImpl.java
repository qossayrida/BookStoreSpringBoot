package org.example.gradleproject.service.impl;

import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.*;
import org.example.gradleproject.mapper.Converter;
import org.example.gradleproject.mapper.EntityMapper;
import org.example.gradleproject.repository.BaseRepository;
import org.example.gradleproject.service.AuthorService;
import org.example.gradleproject.service.BaseService;
import org.example.gradleproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author,AuthorDTO,Long> implements AuthorService {

    @Autowired
    BaseRepository<Author, Long> authorRepository;

    @Autowired
    Converter<Author, AuthorDTO> authorConverter;

    @Override
    JpaRepository<Author, Long> getRepository() {
        return authorRepository;
    }

    @Override
    Converter<Author, AuthorDTO> getConverter() {
        return authorConverter;
    }

}