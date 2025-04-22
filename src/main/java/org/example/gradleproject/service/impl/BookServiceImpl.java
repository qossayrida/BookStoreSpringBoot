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

    public List<SaleDTO> getBookSales(Long bookId) {
        Book book = bookRepository.findById(bookId).get();

        List<Sale> sales = book.getSales();
        return sales.stream()
                .map(EntityMapper.entityMapper::saleToSaleDTO)
                .collect(Collectors.toList());
    }
}
