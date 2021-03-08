package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("authors")
public class AuthorsController {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("index.html")
    public String GetAuthorsPage(Model model) {
        model.addAttribute("authorData", authorsService.getAuthorsData());
        return "/authors/index.html";
    }
}
