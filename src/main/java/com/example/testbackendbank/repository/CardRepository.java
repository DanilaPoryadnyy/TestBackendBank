package com.example.testbackendbank.repository;

import com.example.testbackendbank.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}