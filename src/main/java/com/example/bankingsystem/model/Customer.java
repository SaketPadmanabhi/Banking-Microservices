package com.example.bankingsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Getter                         //Reduces boiler-plate code lombok annotations
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity                        //Marks this as a database table.
@Table(name = "customers")

public class Customer {

    @Id                       //Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)   //Auto-Increments The id
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 50)   //Enforces Column Constraints
    private String email;

    @Column(nullable = false, unique = true, length = 15)
    private String phone;


}
