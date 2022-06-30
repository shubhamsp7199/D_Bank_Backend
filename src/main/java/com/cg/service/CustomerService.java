package com.cg.service;

import com.cg.exception.DuplicateCustomerException;
import com.cg.exception.NoSuchCustomerException;
import com.cg.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CustomerService {

    public Customer addCustomer(Customer customer) throws DuplicateCustomerException;

    public Customer viewCustomerByCustomerId(int customerId) throws NoSuchCustomerException;

    public Customer viewCustomerByAccountNumber(int accountNumber) throws NoSuchCustomerException;

    List<Customer> getAllCustomer();
}
