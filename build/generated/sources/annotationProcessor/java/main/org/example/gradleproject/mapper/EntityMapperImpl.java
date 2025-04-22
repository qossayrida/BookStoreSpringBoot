package org.example.gradleproject.mapper;

import javax.annotation.processing.Generated;
import org.example.gradleproject.dto.AuthorDTO;
import org.example.gradleproject.dto.BookDTO;
import org.example.gradleproject.dto.SaleDTO;
import org.example.gradleproject.entity.Author;
import org.example.gradleproject.entity.Book;
import org.example.gradleproject.entity.Category;
import org.example.gradleproject.entity.Sale;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-22T14:15:05+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19.0.2 (Amazon.com Inc.)"
)
public class EntityMapperImpl implements EntityMapper {

    @Override
    public AuthorDTO authorToAuthorDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setAuthorID( author.getId() );
        authorDTO.setName( author.getName() );
        authorDTO.setCountry( author.getCountry() );

        return authorDTO;
    }

    @Override
    public Author authorDTOToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDTO.getAuthorID() );
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

        bookDTO.setAuthorId( bookAuthorId( book ) );
        bookDTO.setBookID( book.getId() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setPrice( book.getPrice() );
        if ( book.getCategory() != null ) {
            bookDTO.setCategory( book.getCategory().name() );
        }

        return bookDTO;
    }

    @Override
    public Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getAuthorId() );
        book.setTitle( bookDTO.getTitle() );
        book.setPrice( bookDTO.getPrice() );
        if ( bookDTO.getCategory() != null ) {
            book.setCategory( Enum.valueOf( Category.class, bookDTO.getCategory() ) );
        }

        return book;
    }

    @Override
    public SaleDTO saleToSaleDTO(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setBookId( saleBookId( sale ) );
        saleDTO.setSaleID( sale.getId() );
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

        sale.setId( saleDTO.getSaleID() );
        sale.setQuantity( saleDTO.getQuantity() );
        sale.setSaleDate( saleDTO.getSaleDate() );

        return sale;
    }

    private Long bookAuthorId(Book book) {
        if ( book == null ) {
            return null;
        }
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        Long id = author.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long saleBookId(Sale sale) {
        if ( sale == null ) {
            return null;
        }
        Book book = sale.getBook();
        if ( book == null ) {
            return null;
        }
        Long id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
