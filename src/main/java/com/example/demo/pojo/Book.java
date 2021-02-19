package com.example.demo.pojo;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

//see https://fxrobin.developpez.com/tutoriels/java/lombok-retour-experience/
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Formula("(select count(v.id) from version v where v.book_id = id)")
    private Integer nbOfVersion;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    @OneToMany(mappedBy="book", fetch = FetchType.EAGER)
    private List<Version> versionList;
}