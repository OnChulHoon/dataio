package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataIoController {

    @GetMapping(value = "/home")
    public String showHome(Model model){
        System.out.println("Method Started!! => showHome()");
        model.addAttribute("message", "Hello~ SpringBoot! :)");
        return "home";
    }
}
