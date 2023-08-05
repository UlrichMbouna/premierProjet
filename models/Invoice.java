package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name ="bills")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;


    @Column
    private long id_order;

    @Column
    private long id_cutomer;

    @Column
    private String date;

    @Column
    private String status;
    
}
