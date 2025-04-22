package org.example.gradleproject.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.*;
import org.example.gradleproject.repository.BookRepository;
import org.example.gradleproject.service.*;
import org.example.gradleproject.utilities.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public ApiResponse<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAll();
        return ApiResponse.success(books, "books fetched successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<BookDTO> getBook(@PathVariable UUID id) {
        BookDTO book = bookService.getElement(id);
        return ApiResponse.success(book, "Book fetched successfully");
    }

    @PostMapping
    @Parameter(name = "uuid", hidden = true)
    public ApiResponse<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.create(bookDTO);
        return ApiResponse.success(createdBook, "Book created successfully");
    }

    @PutMapping
    public ApiResponse<BookDTO> updateBook(@RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.update(bookDTO);
        return ApiResponse.success(updatedBook, "Book updated successfully");
    }
}
