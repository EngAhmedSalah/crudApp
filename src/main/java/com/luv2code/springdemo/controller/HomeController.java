package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String homePage()
    {
        return "index";
    }

    @RequestMapping("/showMyLoginPage")
    public String showForm()
    {
        return "fancy-form";
    }
}
