
package com.example.bookapp;

import org.springframework.core.io.ClassPathResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
public class BookController {
    private final List<Book> books;

    public BookController() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.books = mapper.readValue(
            new ClassPathResource("books.json").getInputStream(),
            new TypeReference<List<Book>>() {}
        );
    }

    @GetMapping("/findAllBooks")
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(books);
    }
}
