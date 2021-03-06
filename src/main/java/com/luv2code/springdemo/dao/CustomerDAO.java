package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerDAO
{
    public List getCustomers();
    public List<Customer> getSearchCustomers(String searchKey);
    public Customer getCustomer(int id);
    public void addCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
}
