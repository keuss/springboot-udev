package com.example.demo.service;

import com.example.demo.helper.Mapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.BookJSON;
import com.example.demo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;

    @Resource
    private Mapper mapper;

    public List<BookJSON> getAllBooks() {
        log.info("Called for getAllBooks ...");
        List<Book> bookList = bookRepository.findAll();
        return mapper.mapTo(bookList);
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "books", key = "#id")
    public BookJSON getBookById(long id) {
        log.info("Called for getBookById ...");
        Book b = bookRepository.getOne(id);
        return mapper.mapTo(b);
    }

    public BookJSON addBook(BookJSON book) {
        Book b = bookRepository.save(mapper.mapTo(book));
        return mapper.mapTo(b);
    }

    public List<BookJSON> getAllBooksByAuthor(String author) {
        List<Book> bookList = bookRepository.findByAuthor(author);
        return mapper.mapTo(bookList);
    }

    public List<BookJSON> getAllBooksByTitle(String title) {
        List<Book> bookList = bookRepository.findByTitle(title);
        return mapper.mapTo(bookList);
    }
}
