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
@Transactional
public class CustomerDAOImpl implements CustomerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getCustomers()
    {
        Session currentSession = sessionFactory.getCurrentSession();

        //is a query sorted by email
        Query theQuery = currentSession.createQuery("from Customer");
        List customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public List<Customer> getSearchCustomers(String theSearchName)
    {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0)
        {
            // search for firstName or lastName ... case insensitive
            //theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery = currentSession.createQuery("from Customer where firstName=:theName", Customer.class);
            theQuery.setParameter("theName", theSearchName.toLowerCase());

        }
        else
        {
            // theSearchName is empty ... so just get all customers
            theQuery = currentSession.createQuery("from Customer", Customer.class);
        }

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
    }

    @Override
    public Customer getCustomer(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, id);
    }

    @Override

    public void addCustomer(Customer customer)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }


    @Override
    @Transactional
    public void deleteCustomer(Customer customer)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(customer);
    }
}
