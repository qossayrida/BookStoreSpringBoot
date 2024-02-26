package org.example.gradleproject.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long bookID;
    private String title;
    private Double price;
    private String category;
    private Long authorId;
}
