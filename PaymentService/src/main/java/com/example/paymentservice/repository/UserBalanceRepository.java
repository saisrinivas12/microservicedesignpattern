package com.example.paymentservice.repository;

import com.example.paymentservice.entities.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBalanceRepository extends JpaRepository<UserBalance,String> {
}
