package org.example.gradleproject.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id()
    private Long id;
}
