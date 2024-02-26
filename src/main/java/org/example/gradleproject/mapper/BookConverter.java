package org.example.gradleproject.mapper;

import org.example.gradleproject.entity.*;
import org.example.gradleproject.dto.*;
import org.springframework.stereotype.Component;

@Component
public class BookConverter implements Converter<Book, BookDTO> {

    @Override
    public BookDTO convertToDTO(Book book) {
        return EntityMapper.entityMapper.bookToBookDTO(book);
    }

    @Override
    public Book convertToEntity(BookDTO bookDTO) {
        return EntityMapper.entityMapper.bookDTOToBook(bookDTO);
    }
}
