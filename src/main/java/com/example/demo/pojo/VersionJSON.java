package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class VersionJSON implements Serializable {

    private Long id;
    @NotEmpty
    private String description;
    private String date;
}
