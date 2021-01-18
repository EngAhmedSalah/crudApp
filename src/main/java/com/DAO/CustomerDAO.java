package com.DAO;

import com.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAO implements CustomerDAOInterface
{
    @Autowired
    private SessionFactory sessionFactory ;

    @Override
    @Transactional
    public List<Customer> getCustomers()
    {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from customer" , Customer.class);
        List<Customer> customers = query.list();
        return customers;
    }

    @Override
    public Customer getCustomer()
    {
        return null;
    }
}
