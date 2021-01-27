package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers()
    {
        Session currentSession = sessionFactory.getCurrentSession();

        //is a query sorted by email
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by email", Customer.class);
        List<Customer> customers = theQuery.list();
        return customers;
    }

    @Override
    public Customer getCustomer(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class , id);
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public void updateCustomer(Customer customer)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        //Query<Customer> query = currentSession.createQuery("update customer set first_name=:a , last_name=:b , email=:c where id=:d");
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(customer);
    }
}
