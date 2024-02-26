package org.example.gradleproject.controller;

import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.*;
import org.example.gradleproject.repository.AuthorRepository;
import org.example.gradleproject.repository.BaseRepository;
import org.example.gradleproject.repository.BookRepository;
import org.example.gradleproject.service.AuthorService;
import org.example.gradleproject.service.BaseService;
import org.example.gradleproject.utilities.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/get-author/all")
    public ApiResponse<List<AuthorDTO>> getAllAuthor() {
        List<AuthorDTO> authors = authorService.getAll();
        return ApiResponse.success(authors, "Authors fetched successfully");
    }

    @GetMapping("/get-author/{id}")
    public ApiResponse<AuthorDTO> getAuthor(@PathVariable Long id) {
        return ApiResponse.success(authorService.getElement(id), "Author fetched successfully");
    }

//    @GetMapping("/get-books-for-author/{id}")
//    public ApiResponse<List<BookDTO>> getBooksByAuthorId(@PathVariable Long id) {
//        List<BookDTO> books = authorService.getBooksByAuthorId(id);
//        return ApiResponse.success(books, "books fetched successfully");
//    }
//
//    @PostMapping("/add-author")
//    public ApiResponse<AuthorDTO> addAuthor(@RequestBody Author author) {
//        AuthorDTO newAuthor = authorService.addAuthor(author);
//        return ApiResponse.success(newAuthor, "Author added successfully");
//    }

//    @DeleteMapping("/remove-author/{id}")
//    public ApiResponse<Void> removeAuthor(@PathVariable Long id) {
//        boolean removed = authorService.removeAuthor(id);
//        if (removed) {
//            return ApiResponse.success(null, "Author removed successfully");
//        } else {
//            return ApiResponse.error("Error removing Author");
//        }
//    }
//
//    @PutMapping("/update-author/{id}")
//    public ApiResponse<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        AuthorDTO updatedAuthor = authorService.updateAuthor(id, body);
//        return ApiResponse.success(updatedAuthor, "Author updated successfully");
//    }
//
}
