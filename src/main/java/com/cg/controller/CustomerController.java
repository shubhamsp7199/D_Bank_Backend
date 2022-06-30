package com.cg.controller;

import com.cg.exception.DuplicateCustomerException;
import com.cg.exception.NoSuchCustomerException;
import com.cg.model.Customer;
import com.cg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    http://localhost:8081/customer/addCustomer
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws DuplicateCustomerException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Customer add successfully.");
        return new ResponseEntity<Customer>(customerService.addCustomer(customer), headers, HttpStatus.CREATED);
    }

//    http://localhost:8081/customer/getCustomerById/
    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable(name = "customerId") int customerId) throws NoSuchCustomerException{
        Customer customer = customerService.viewCustomerByCustomerId(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This customer is available.");
        ResponseEntity<Customer> response = new ResponseEntity<Customer>(customer, headers, HttpStatus.OK);
        return response;
    }

//    http://localhost:8081/customer/getCustomerByAccountNumber/
    @GetMapping("/getCustomerByAccountNumber/{accountNumber}")
    public ResponseEntity<Customer> getCustomerByAccountNumber(@PathVariable(name = "accountNumber") int accountNumber) throws NoSuchCustomerException{
        Customer customer = customerService.viewCustomerByAccountNumber(accountNumber);
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This customer is available.");
        ResponseEntity<Customer> response = new ResponseEntity<Customer>(customer, headers, HttpStatus.OK);
        return response;
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
