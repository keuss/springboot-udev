package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthResponse implements Serializable {
    private String appToken;
    private boolean isAuthenticate = false;
    private boolean isAuthorize = false;
}
