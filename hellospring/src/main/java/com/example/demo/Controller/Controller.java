package com.example.demo.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller 
public class Controller {

    @GetMapping("/about") 
    public String about() {
        return "about"; 
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "Hà Nguyễn Tiến Thịnh") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "hello"; 
    }
}