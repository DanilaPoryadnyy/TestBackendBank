package com.example.testbackendbank.repository;

import com.example.testbackendbank.entity.UserData;
import com.example.testbackendbank.entity.UserInstance;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {
    UserData findByUser(UserInstance userInstance);
    UserData findByPhone(String phone);
    UserData findByPhoneAndFirstNameAndLastNameAndMiddleNameAndBirthdate(
            String phone, String firstName, String lastName, String middleName, LocalDate birthdate);
}