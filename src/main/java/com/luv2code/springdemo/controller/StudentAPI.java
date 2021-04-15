package com.luv2code.springdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class StudentAPI
{
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/student")
    public List getAll()
    {
        return customerDAO.getCustomers();
    }

    @GetMapping("/student/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException
    {

        // just index into the list ... keep it simple for now

        // check the studentId against list size
        Customer customer = customerDAO.getCustomer(customerId);
        if ( customerId < 0 || customer == null)
        {
            throw new CustomerNotFoundException("Student id not found - " + customerId);
        }

        return customer;

    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {

        CustomerErrorResponse error = new CustomerErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {

        CustomerErrorResponse error = new CustomerErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }
}