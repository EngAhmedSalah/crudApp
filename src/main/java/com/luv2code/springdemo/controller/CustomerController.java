package com.luv2code.springdemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel)
    {

        // get customers from the dao
        List<Customer> theCustomers = customerDAO.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
    @RequestMapping("/showForm")
    public String showForm(Model model)
    {
        Customer customer = new Customer();
        model.addAttribute("customer" , customer);
        return "addCustomer";
    }
    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") Customer customer)
    {
        customerDAO.addCustomer(customer);
        return "redirect:/customer/list";
    }
}