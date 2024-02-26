package org.example.gradleproject.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity
@Table(name = "authors")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "AuthorID"))
public class Author extends BaseModel{
    String  Name ;
    String Country ;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;
}
