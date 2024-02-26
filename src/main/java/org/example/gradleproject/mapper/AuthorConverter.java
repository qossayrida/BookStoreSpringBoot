package org.example.gradleproject.mapper;

import org.example.gradleproject.entity.*;
import org.example.gradleproject.dto.*;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter implements Converter<Author, AuthorDTO> {

    @Override
    public AuthorDTO convertToDTO(Author author) {
        return EntityMapper.entityMapper.authorToAuthorDTO(author);
    }

    @Override
    public Author convertToEntity(AuthorDTO authorDTO) {
        return EntityMapper.entityMapper.authorDTOToAuthor(authorDTO);
    }
}
