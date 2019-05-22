package com.example.demo.helper;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.BookJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public Book mapTo(BookJSON bookJSON) {
        Assert.notNull(bookJSON, "The bookJSON must not be null");
        Book b = new Book();
        // must not set id !
        b.setTitle(bookJSON.getTitle());
        b.setAuthor(bookJSON.getAuthor());
        return b;
    }

    public BookJSON mapTo(Book book) {
        Assert.notNull(book, "The book must not be null");
        BookJSON bJSON = new BookJSON();
        bJSON.setTitle(book.getTitle());
        bJSON.setAuthor(book.getAuthor());
        bJSON.setId(book.getId());
        return bJSON;
    }

    public List<BookJSON> mapTo(List<Book> bookList) {
        Assert.notNull(bookList, "The bookList must not be null");
        return bookList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
