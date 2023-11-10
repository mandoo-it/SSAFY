package com.ssafy.web9to6.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @ApiOperation("MJ-CAT main page")
    @GetMapping("/")
    public String index(){ return "hello"; }

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String hello(){ return "hello"; }
}


