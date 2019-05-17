package com.example.demo.controller;

import com.example.demo.pojo.BookJSON;
import com.example.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BookJSON> getAll() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public BookJSON getBook(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookJSON addBook(@Valid @RequestBody BookJSON book) {
        // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
        // or JPA RollbackException (DB side)
        return bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/author/{author}")
    // FIXME not good path for REST ...
    public List<BookJSON> getAllByAuthor(@PathVariable String author) {
        return bookService.getAllBooksByAuthor(author);
    }
}