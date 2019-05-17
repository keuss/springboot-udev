package com.example.demo.service;

import com.example.demo.helper.Mapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.BookJSON;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;

    @Resource
    private Mapper mapper;

    public List<BookJSON> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return mapper.mapTo(bookList);
    }

    public BookJSON getBookById(long id) {
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
}
