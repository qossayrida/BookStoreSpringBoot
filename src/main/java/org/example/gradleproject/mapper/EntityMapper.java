package org.example.gradleproject.mapper;

import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.*;
import java.util.stream.Collectors;

@Mapper
public interface EntityMapper {

    EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

    // Author conversions
    @Mapping(target = "books", expression = "java(mapToReferences(author.getBooks()))")
    AuthorDTO authorToAuthorDTO(Author author);

    @Mapping(target = "books", ignore = true)
    Author authorDTOToAuthor(AuthorDTO authorDTO);

    // Book conversions
    @Mapping(target = "author", source = "author", qualifiedByName = "entityToReference")
    @Mapping(target = "sales", expression = "java(mapToReferences(book.getSales()))")
    BookDTO bookToBookDTO(Book book);

    @Mapping(target = "author", expression = "java(referenceToEntity(bookDTO.getAuthor(), Author.class))")
    @Mapping(target = "sales", ignore = true)
    Book bookDTOToBook(BookDTO bookDTO);

    // Sale conversions
    @Mapping(target = "book", source = "book", qualifiedByName = "entityToReference")
    SaleDTO saleToSaleDTO(Sale sale);

    @Mapping(target = "book", expression = "java(referenceToEntity(saleDTO.getBook(), Book.class))")
    Sale saleDTOToSale(SaleDTO saleDTO);

    // Generic helper methods
    @Named("entityToReference")
    default Reference entityToReference(BaseEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Reference(entity.getUuid());
    }

    @Named("referenceToEntity")
    default <T extends BaseEntity> T referenceToEntity(Reference reference, Class<T> clazz) {
        if (reference == null) {
            return null;
        }
        try {
            T entity = clazz.getDeclaredConstructor().newInstance();
            entity.setUuid(reference.getUuid());
            return entity;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating instance of " + clazz.getSimpleName(), e);
        }
    }


    default <T extends BaseEntity> List<Reference> mapToReferences(List<T> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(entity -> new Reference(entity.getUuid()))
                .collect(Collectors.toList());
    }
}