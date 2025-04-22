package org.example.gradleproject.controller;

import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ApiResponse<List<AuthorDTO>> getAllAuthor() {
        List<AuthorDTO> authors = authorService.getAll();
        return ApiResponse.success(authors, "Authors fetched successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<AuthorDTO> getAuthor(@PathVariable UUID id) {
        return ApiResponse.success(authorService.getElement(id), "Author fetched successfully");
    }

    @PostMapping
    @Parameter(name = "uuid", hidden = true)
    public ApiResponse<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO createdAuthor = authorService.create(authorDTO);
        return ApiResponse.success(createdAuthor, "Author created successfully");
    }

    @PutMapping
    public ApiResponse<AuthorDTO> updateAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO updatedAuthor = authorService.update(authorDTO);
        return ApiResponse.success(updatedAuthor, "Author updated successfully");
    }
}
