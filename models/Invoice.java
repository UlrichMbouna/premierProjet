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


    @Column(name="id_order")
    private long id_order;

    @Column(name="id_cutomer")
    private long id_cutomer;

    @Column(name="date")
    private String date;

    @Column(name="status")
    private String status;
    
}
