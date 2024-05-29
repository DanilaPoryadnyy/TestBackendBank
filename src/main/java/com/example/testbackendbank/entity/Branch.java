package com.example.testbackendbank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "branchs")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branchs_id_gen")
    @SequenceGenerator(name = "branchs_id_gen", sequenceName = "branchs_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "branch_name", length = Integer.MAX_VALUE)
    private String branchName;

    @Column(name = "branch_location", length = Integer.MAX_VALUE)
    private String branchLocation;
}