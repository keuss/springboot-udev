package com.example.demo.controller;

import com.example.demo.pojo.AuthJSON;
import com.example.demo.pojo.AuthResponse;
import com.example.demo.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = {"Auth"})
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    @Resource
    AuthService authService;

    @ApiOperation(value = "Authenticate user", response = AuthResponse.class)
    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthResponse authenticate(@ApiParam(value = "User Fields") @Valid @RequestBody AuthJSON authJSON) {
        return authService.authenticate(authJSON);
    }
}
