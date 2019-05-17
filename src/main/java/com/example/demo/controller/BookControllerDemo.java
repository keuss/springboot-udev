package com.example.demo.controller;

import com.example.demo.pojo.BookJSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "mybooks", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookControllerDemo {


    private List<BookJSON> bookJSONS = new ArrayList<>();

    public BookControllerDemo() {
        BookJSON bookJSON_1 = new BookJSON();
        bookJSON_1.setId(1L);
        bookJSON_1.setAuthor("");
        bookJSON_1.setTitle("LOTR");
        this.bookJSONS.add(bookJSON_1);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookJSON> getAll() {
        return this.bookJSONS;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public BookJSON getBook(@PathVariable long id) {
        // TODO search y in in bookJSONS
        BookJSON bookJSON = new BookJSON();
        bookJSON.setId(1L);
        bookJSON.setTitle("");
        bookJSON.setAuthor("toto");
        return bookJSON;
    }

    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookJSON addBook(@Valid @RequestBody BookJSON book) {
        this.bookJSONS.add(book);
        return book;
    }
}