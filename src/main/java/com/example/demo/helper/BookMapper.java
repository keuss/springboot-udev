package com.example.demo.helper;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.BookJSON;
import com.example.demo.pojo.BookJSONRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Resource
    private VersionMapper versionMapper;

    public BookJSON mapTo(Book book) {
        Assert.notNull(book, "The book must not be null");
        BookJSON bJSON = new BookJSON();
        bJSON.setTitle(book.getTitle());
        bJSON.setAuthor(book.getAuthor());
        bJSON.setId(book.getId());
        bJSON.setVersions(versionMapper.mapTo(book.getVersionList()));
        bJSON.setNbOfVersion(book.getNbOfVersion());
        return bJSON;
    }

    public List<BookJSON> mapTo(List<Book> bookList) {
        Assert.notNull(bookList, "The bookList must not be null");
        return bookList.stream().map(this::mapTo).collect(Collectors.toList());
    }

    public Book mapTo(BookJSONRequest bookJSONRequest) {
        Assert.notNull(bookJSONRequest, "The bookJSONRequest must not be null");
        Book b = new Book();
        // must not set id and calculated Formula !
        b.setTitle(bookJSONRequest.getTitle());
        b.setAuthor(bookJSONRequest.getAuthor());
        return b;
    }
}
