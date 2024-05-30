package com.example.testbackendbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "account_status")
public class AccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_status_id_gen")
    @SequenceGenerator(name = "account_status_id_gen", sequenceName = "account_status_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "idAccountStatus")
    private Set<Account> accounts = new LinkedHashSet<>();

}