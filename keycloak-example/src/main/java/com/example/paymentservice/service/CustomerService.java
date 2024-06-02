package com.example.paymentservice.service;

import com.example.paymentservice.entity.Customer;
import com.example.paymentservice.repository.CustomerRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    @PostConstruct
    public void saveAllData(){
        List<Customer> customers = Stream.of(new Customer(101,"saisrinivas","Medchal"),
                new Customer(102,"Karthik","Hyderabad"),new Customer(103,"vamsi","Mumbai")).collect(Collectors.toList());

        repository.saveAll(customers);
    }

    public List<Customer>getAllCustomers(){
        return repository.findAll();
    }


    public Customer getCustomerById(Integer customerId){
        Customer customer = repository.findById(customerId).orElseThrow(()-> new RuntimeException("Requested CustomerId Not Found on the server"));

        return customer;
    }

}
