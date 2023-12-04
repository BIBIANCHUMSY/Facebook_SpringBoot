package com.facebook.facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("")
    public String firstPage(){
        return "redirect:/welcomes";
    }
}
