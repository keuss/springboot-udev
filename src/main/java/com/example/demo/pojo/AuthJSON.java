package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AuthJSON implements Serializable {

    @NotEmpty
    private String userId;
    @NotEmpty
    private String pwd;
}
