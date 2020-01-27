package com.searchmovie.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
    @GetMapping("/login")
    public String goUserHome(){

        return "login";
    }
    @PostMapping("/login")
    public String goIndexPage(){
        return "redirect:/index?";
    }

}
