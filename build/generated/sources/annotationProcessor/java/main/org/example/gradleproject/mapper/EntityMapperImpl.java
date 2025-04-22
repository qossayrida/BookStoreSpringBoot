package org.example.gradleproject.mapper;

import javax.annotation.processing.Generated;
import org.example.gradleproject.dto.AuthorDTO;
import org.example.gradleproject.dto.BookDTO;
import org.example.gradleproject.dto.SaleDTO;
import org.example.gradleproject.entity.Author;
import org.example.gradleproject.entity.Book;
import org.example.gradleproject.entity.Sale;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-22T20:41:02+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19.0.2 (Amazon.com Inc.)"
)
public class EntityMapperImpl implements EntityMapper {

    @Override
    public AuthorDTO authorToAuthorDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setUuid( author.getUuid() );
        authorDTO.setName( author.getName() );
        authorDTO.setCountry( author.getCountry() );

        authorDTO.setBooks( mapToReferences(author.getBooks()) );

        return authorDTO;
    }

    @Override
    public Author authorDTOToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setUuid( authorDTO.getUuid() );
        author.setName( authorDTO.getName() );
        author.setCountry( authorDTO.getCountry() );

        return author;
    }

    @Override
    public BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor( entityToReference( book.getAuthor() ) );
        bookDTO.setUuid( book.getUuid() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setPrice( book.getPrice() );
        bookDTO.setCategory( book.getCategory() );

        bookDTO.setSales( mapToReferences(book.getSales()) );

        return bookDTO;
    }

    @Override
    public Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setUuid( bookDTO.getUuid() );
        book.setTitle( bookDTO.getTitle() );
        book.setPrice( bookDTO.getPrice() );
        book.setCategory( bookDTO.getCategory() );

        book.setAuthor( referenceToEntity(bookDTO.getAuthor(), Author.class) );

        return book;
    }

    @Override
    public SaleDTO saleToSaleDTO(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setBook( entityToReference( sale.getBook() ) );
        saleDTO.setUuid( sale.getUuid() );
        saleDTO.setQuantity( sale.getQuantity() );
        saleDTO.setSaleDate( sale.getSaleDate() );

        return saleDTO;
    }

    @Override
    public Sale saleDTOToSale(SaleDTO saleDTO) {
        if ( saleDTO == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setUuid( saleDTO.getUuid() );
        sale.setQuantity( saleDTO.getQuantity() );
        sale.setSaleDate( saleDTO.getSaleDate() );

        sale.setBook( referenceToEntity(saleDTO.getBook(), Book.class) );

        return sale;
    }
}
