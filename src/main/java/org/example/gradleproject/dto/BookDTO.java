package org.example.gradleproject.dto;


import lombok.*;
import java.util.*;
import org.example.gradleproject.entity.*;
import io.swagger.v3.oas.annotations.media.Schema;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private UUID uuid;

    private String title;
    private Double price;
    private Category category;
    private Reference author;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<Reference> sales;
}