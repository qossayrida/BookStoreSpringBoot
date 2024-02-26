package org.example.gradleproject.mapper;

import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);


    @Mapping(source = "id", target = "authorID")
    AuthorDTO authorToAuthorDTO(Author author);

    @Mapping(source = "authorID", target = "id")
    Author authorDTOToAuthor(AuthorDTO authorDTO);

    @Mapping(target = "authorId", source = "author.id")
    @Mapping(source = "id", target = "bookID")
    BookDTO bookToBookDTO(Book book);


    @Mapping(source = "authorId", target = "id")
    Book bookDTOToBook(BookDTO bookDTO);


    @Mapping(target = "bookId", source = "book.id")
    @Mapping(source = "id", target = "saleID")
    SaleDTO saleToSaleDTO(Sale sale);

    @Mapping(source = "saleID", target = "id")
    Sale saleDTOToSale(SaleDTO saleDTO);
}

