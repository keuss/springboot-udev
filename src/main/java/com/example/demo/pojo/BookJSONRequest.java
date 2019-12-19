package com.example.demo.pojo;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class BookJSONRequest implements Serializable {

    // Serializable to avoid Cannot serialize redis ERROR !

    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
}
