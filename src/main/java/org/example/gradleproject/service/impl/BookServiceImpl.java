package org.example.gradleproject.service.impl;


import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.*;
import org.example.gradleproject.mapper.Converter;
import org.example.gradleproject.repository.BookRepository;
import org.example.gradleproject.service.*;
import org.example.gradleproject.entity.Sale;
import org.example.gradleproject.mapper.EntityMapper;
import org.example.gradleproject.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.gradleproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book,BookDTO,Long> implements BookService{

    @Autowired
    BaseRepository<Book, Long> bookRepository;

    @Autowired
    Converter<Book,BookDTO> bookConverter;


    @Override
    JpaRepository getRepository() {
        return bookRepository;
    }

    @Override
    Converter<Book, BookDTO> getConverter() {
        return bookConverter;
    }

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = EntityMapper.entityMapper.bookDTOToBook(bookDTO);
        book = bookRepository.save(book);
        return EntityMapper.entityMapper.bookToBookDTO(book);
    }


    public List<SaleDTO> getBookSales(Long bookId) {
        Book book = bookRepository.findById(bookId).get();

        List<Sale> sales = book.getSales();
        return sales.stream()
                .map(EntityMapper.entityMapper::saleToSaleDTO)
                .collect(Collectors.toList());
    }


//    public BookDTO getBook(Long id){
//        return bookMapper.mapModelToDto(bookRepository.findById(id).get());
//    }
//
//    public boolean removeBook(Long id){
//        if(!bookRepository.findById(id).equals(Optional.empty())){
//            bookRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//
//    public BookDTO updateBook (Long id, Map<String,String> body){
//         Book book = bookRepository.findById(id).orElse(new Book());
//         book.setPrice(Double.parseDouble(body.get("price")));
//         book.setTitle(body.get("title"));
//         book.setAuthorID(Integer.parseInt(body.get("authorID")));
//         bookRepository.save(book);
//         return bookMapper.mapModelToDto(book);
//    }

//    public BookDTO addBook (Map<String,String> body){
//        Book book = new Book(Integer.parseInt(body.get("bookID")),body.get("title"),Integer.parseInt(body.get("authorID")),Double.parseDouble(body.get("price")));
//        return BookMapper.mapToBookDto(bookRepository.save(book));
//    }
}
