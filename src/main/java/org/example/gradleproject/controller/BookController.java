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

//   @PostMapping("/add-book")
//    public ApiResponse<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
//        BookDTO createdBook = bookService.addBook(bookDTO);
//        return ApiResponse.success(createdBook, "Book added successfully");
//    }



//
//    @DeleteMapping("/remove-book/{id}")
//    public ApiResponse<Void> removeBook(@PathVariable Long id) {
//        boolean removed = bookService.removeBook(id);
//        if (removed) {
//            return ApiResponse.success(null, "Book removed successfully");
//        } else {
//            return ApiResponse.error("Error removing book");
//        }
//    }
//
//    @PutMapping("/update-book/{id}")
//    public ApiResponse<BookDTO> updateBook(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        BookDTO updatedBook = bookService.updateBook(id, body);
//        return ApiResponse.success(updatedBook, "Book updated successfully");
//    }

//    @PostMapping("/add-book")
//    public ApiResponse<BookDTO> addBook(@RequestBody @Validated Map<String, String> body) {
//        BookDTO newBook = bookService.addBook(body);
//        return ApiResponse.success(newBook, "Book added successfully");
//    }

    @GetMapping("/")
    public ApiResponse<String> getHome() {
        return ApiResponse.success("GG", "Home page accessed successfully");
    }
}
