package com.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    @RequestMapping(value = "/list"  , method = RequestMethod.GET)
    public String listCustomer(Model model)
    {
        model.addAttribute("message" , "this is a message");
        return "list-customer";
    }
}
