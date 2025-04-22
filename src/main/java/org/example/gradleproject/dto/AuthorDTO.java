package org.example.gradleproject.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private UUID uuid;

    private String name;
    private String country;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<Reference> books;
}

