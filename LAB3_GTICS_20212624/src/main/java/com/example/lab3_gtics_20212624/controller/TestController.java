package com.example.lab3_gtics_20212624.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class TestController {
    @GetMapping(value = "")
    public String test() {
        return "fragments/navbar";
    }
}
