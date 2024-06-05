package com.example.testbackendbank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "account_type")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_type_id_gen")
    @SequenceGenerator(name = "account_type_id_gen", sequenceName = "account_type_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type_name", unique = true, nullable = false)
    private String typeName;

    @JsonBackReference
    @OneToMany(mappedBy = "idAccountType")
    private Set<Account> accountsType = new LinkedHashSet<>();
}