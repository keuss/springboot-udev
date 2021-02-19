package com.example.demo.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

//see https://fxrobin.developpez.com/tutoriels/java/lombok-retour-experience/
@Data
@Entity
@Slf4j
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
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private List<Version> versionList;

    @PostLoad
    private void postLoadFunction() {
        // see https://nullbeans.com/configuring-postload-and-postupdate-in-jpa-hibernate/
        // @PostLoad callback to populate a transient property with the result of some calculation
        log.info("#### Book PostLoad method called for book id {} and nb of version {} ####", id, versionList != null ? versionList.size() : 0);
    }
}