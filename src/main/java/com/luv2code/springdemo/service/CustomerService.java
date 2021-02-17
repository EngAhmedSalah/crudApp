package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface CustomerService
{
    public List<Customer> getCustomers();
    public List<Customer> getSearchCustomers(String searchKey);
    public Customer getCustomer(int id);
    public void addCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
}
