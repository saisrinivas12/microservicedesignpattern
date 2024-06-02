package com.example.paymentservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_TABLE")
public class Customer {

    @Id
    private int customerId;


    private String customerName;


    private String customerLocation;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    public Customer(int customerId, String customerName, String customerLocation) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerLocation = customerLocation;
    }

    public Customer(){}
}
