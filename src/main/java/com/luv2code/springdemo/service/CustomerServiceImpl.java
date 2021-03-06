package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List getCustomers()
    {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public List<Customer> getSearchCustomers(String searchKey)
    {
        return  customerDAO.getSearchCustomers(searchKey);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id)
    {
        return customerDAO.getCustomer(id);
    }

    @Override
    public void addCustomer(Customer customer)
    {
        customerDAO.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer)
    {
        customerDAO.deleteCustomer(customer);
    }
}
