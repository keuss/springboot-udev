package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookJSON {

    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;


}
