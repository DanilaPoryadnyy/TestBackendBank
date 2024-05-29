package com.example.testbackendbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_id_gen")
    @SequenceGenerator(name = "accounts_id_gen", sequenceName = "accounts_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_instance", nullable = false)
    private UserInstance userInstance;

    @Column(name = "balance")
    private Long balance;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_status", nullable = false)
    private AccountStatus accountStatus;

    @Column(name = "account_type", length = Integer.MAX_VALUE)
    private String accountType;

    @Column(name = "currency", length = Integer.MAX_VALUE)
    private String currency;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

}