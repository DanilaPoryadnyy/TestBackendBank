package com.example.testbackendbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //Временно отключил JPA, т.к. нет БД
public class TestBackendBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBackendBankApplication.class, args);
    }

}
