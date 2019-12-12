package com.example.demo.repository;

import com.example.demo.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/

    List<Book> findByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> findByTitle(String title);
}