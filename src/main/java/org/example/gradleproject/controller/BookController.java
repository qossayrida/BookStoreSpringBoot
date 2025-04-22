package org.example.gradleproject.controller;

import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.*;
import org.example.gradleproject.repository.BookRepository;
import org.example.gradleproject.service.*;
import org.example.gradleproject.utilities.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/get-book/all")
    public ApiResponse<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAll();
        return ApiResponse.success(books, "books fetched successfully");
    }

    @GetMapping("/get-book/{id}")
    public ApiResponse<BookDTO> getBook(@PathVariable Long id) {
        BookDTO book = bookService.getElement(id);
        return ApiResponse.success(book, "Book fetched successfully");
    }

    @GetMapping("/get-sales-for-book/{id}")
    public ApiResponse<List<SaleDTO>> getBookSales(@PathVariable Long id) {
        List<SaleDTO> sales = bookService.getBookSales(id);
        return ApiResponse.success(sales, "sales fetched successfully");
    }
}
