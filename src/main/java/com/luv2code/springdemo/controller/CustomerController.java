package com.luv2code.springdemo.controller;


import java.util.List;

import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel)
    {

        // get customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();

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
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerID") int id ,  Model model)
    {
        //get the customer from the database
        Customer customer = customerService.getCustomer(id);

        //set customer to model attribute
        model.addAttribute("customer" , customer);
        //send it over the form
        return "addCustomer";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerID") int id)
    {
        Customer customer = customerService.getCustomer(id);
        customerService.deleteCustomer(customer);
        return "redirect:/customer/list";
    }
    @RequestMapping("/search")
    public String searchCustomer(@RequestParam("theSearchName") String searchKey , Model model)
    {
        List<Customer> customers = customerService.getSearchCustomers(searchKey);
        for (Customer l:customers)
        {
            System.out.println(l);
        }
        model.addAttribute("customers" , customers);
        return "list-customers";
    }
}