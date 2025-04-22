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
}
