package org.example.gradleproject.service.impl;

import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.*;
import org.example.gradleproject.mapper.Converter;
import org.example.gradleproject.mapper.EntityMapper;
import org.example.gradleproject.repository.BaseRepository;
import org.example.gradleproject.service.AuthorService;
import org.example.gradleproject.service.BaseService;
import org.example.gradleproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author,AuthorDTO,Long> implements AuthorService {

    @Autowired
    BaseRepository<Author, Long> authorRepository;

    @Autowired
    Converter<Author, AuthorDTO> authorConverter;

    @Override
    JpaRepository<Author, Long> getRepository() {
        return authorRepository;
    }

    @Override
    Converter<Author, AuthorDTO> getConverter() {
        return authorConverter;
    }


//    public AuthorDTO addAuthor (Author author){
//        return EntityMapper.entityMapper.authorToAuthorDTO(authorRepository.save(author));
//    }
//
//    @Override
//    public List<BookDTO> getBooksByAuthorId(Long authorId) {
//        Optional<Author> authorOptional = authorRepository.findById(authorId);
//        if (!authorOptional.isPresent()) {
//            System.out.println("Author with ID " + authorId + " not found");
//        }
//        Author author = authorOptional.get();
//        List<Book> books = author.getBooks();
//        return books.stream()
//                .map(EntityMapper.entityMapper::bookToBookDTO)
//                .collect(Collectors.toList());
//    }

}

/*




    // Method to remove an author
    public boolean removeAuthor(Long id) {
        if(!authorRepository.findById(id).equals(Optional.empty())){
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public AuthorDTO updateAuthor (Long id, Map<String,String> body){
        Author author = authorRepository.findById(id).orElse(new Author());
        author.setName(body.get("name"));
        author.setCountry(body.get("country"));
        authorRepository.save(author);
        return authorMapper.mapModelToDto(author);
    }


}
 */
