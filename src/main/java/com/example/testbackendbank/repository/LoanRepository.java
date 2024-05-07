package com.example.testbackendbank.repository;

import com.example.testbackendbank.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}