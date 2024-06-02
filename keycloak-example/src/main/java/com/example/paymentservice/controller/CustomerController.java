package com.example.paymentservice.controller;

import com.example.paymentservice.entity.Customer;
import com.example.paymentservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RolesAllowed("admin")
    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>>getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customers);
    }
    @RolesAllowed("user")
    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Customer>getCustomerById(@PathVariable(name="customerId")Integer customerId){
        Customer customer= customerService.getCustomerById(customerId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);
    }
}
