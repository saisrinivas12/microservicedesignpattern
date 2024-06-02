package com.example.paymentservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER_BALANCE")
public class UserBalance {

    @Id
    private String userId;
    private String userName;

    private double bankBalance;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public UserBalance(String userId, String userName,double bankBalance) {
        this.userId = userId;
        this.userName = userName;
        this.bankBalance = bankBalance;
    }

    public UserBalance(){}
}
