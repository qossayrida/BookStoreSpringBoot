package org.example.gradleproject.service;

import org.example.gradleproject.dto.BookDTO;
import org.example.gradleproject.dto.SaleDTO;
import org.example.gradleproject.entity.Book;
import org.example.gradleproject.repository.BookRepository;

import java.util.List;

public interface BookService extends BaseService<Book,BookDTO,Long>{
    List<SaleDTO> getBookSales(Long bookId);
}





