package com.example.neidy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping({"/", "/index", "/index.html"})
    public String index() {
        return "forward:/index.html";
    }
}
