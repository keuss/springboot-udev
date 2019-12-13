package com.example.demo.controller;

import com.example.demo.exceptions.ForbiddenException;
import com.example.demo.pojo.BookJSON;
import com.example.demo.service.AuthService;
import com.example.demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(tags = {"Book"})
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private AuthService authService;

    @ApiOperation(value = "Get all Books")
    @RequestMapping(method = RequestMethod.GET)
    public List<BookJSON> getAll() {
        return bookService.getAllBooks();
    }

    @ApiOperation(value = "Get one Book", response = BookJSON.class)
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public BookJSON getBook(@ApiParam(value = "Book id", required = true) @PathVariable long id) {
        return bookService.getBookById(id);
    }

    @ApiOperation(value = "Add Book", response = BookJSON.class)
    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookJSON addBook(@ApiParam(value = "Authorization token", required = true) @RequestHeader("Authorization") String authorization,
                            @ApiParam(value = "Book to Add", required = true) @Valid @RequestBody BookJSON book) {
        // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
        // or JPA RollbackException (DB side)
        if (!authService.isAuthorize(authorization)) {
            throw new ForbiddenException();
        }
        return bookService.addBook(book);
    }

    @ApiOperation(value = "Get Book by Author")
    @RequestMapping(method = RequestMethod.GET, value = "/author/{author}")
    // FIXME not good path for REST ...
    public List<BookJSON> getAllByAuthor(@ApiParam(value = "Author", required = true) @PathVariable String author) {
        return bookService.getAllBooksByAuthor(author);
    }

    @ApiOperation(value = "Get Book by Title")
    @RequestMapping(method = RequestMethod.GET, value = "/title/{title}")
    // FIXME not good path for REST ...
    public List<BookJSON> getAllByTitle(@ApiParam(value = "Title", required = true) @PathVariable String title) {
        return bookService.getAllBooksByTitle(title);
    }
}