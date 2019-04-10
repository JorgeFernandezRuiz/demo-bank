package com.example.bank.demobank.domain.repositories;

import com.example.bank.demobank.domain.entities.Account;
import com.example.bank.demobank.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
