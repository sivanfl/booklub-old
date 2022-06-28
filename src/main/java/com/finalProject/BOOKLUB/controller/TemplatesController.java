package com.finalProject.booklub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplatesController  {

@GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("books")
    public String getbooks(){
        return "books";
    }



}
