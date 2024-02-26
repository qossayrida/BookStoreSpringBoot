package org.example.gradleproject.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    Long AuthorID;
    String Name;
    String Country;
}

