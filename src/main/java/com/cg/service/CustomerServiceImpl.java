package com.cg.service;

import com.cg.exception.DuplicateCustomerException;
import com.cg.exception.NoSuchCustomerException;
import com.cg.model.Customer;
import com.cg.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) throws DuplicateCustomerException {

        if (null == customerRepository.findByAccountNumber(customer.getAccountNumber())) {
            return customerRepository.save(customer);
        }else {
            throw new DuplicateCustomerException("This customer is already registered");
        }
    }


    @Override
    public Customer viewCustomerByCustomerId(int CustomerId) throws NoSuchCustomerException{
        Optional<Customer> bopt = customerRepository.findById(CustomerId);
        if (bopt.isPresent()){
            return bopt.get();
        }else {
            throw new NoSuchCustomerException(CustomerId + " this customer is not found.");
        }
    }

    @Override
    public Customer viewCustomerByAccountNumber(int accountNumber) throws NoSuchCustomerException{
        Optional<Customer> bopt = Optional.ofNullable(customerRepository.findByAccountNumber(accountNumber));
        if (bopt.isPresent()){
            return bopt.get();
        }else {
            throw new NoSuchCustomerException(accountNumber + " this customer is not found.");
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
