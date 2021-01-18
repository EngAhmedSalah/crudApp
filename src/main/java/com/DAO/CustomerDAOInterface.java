package com.DAO;

import com.entity.Customer;

import java.util.List;

public interface CustomerDAOInterface
{
    public List<Customer> getCustomers();
    public Customer getCustomer();
}
