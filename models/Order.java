package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name ="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;

    @ManyToOne
    @JoinColumn(name = "id_employe", nullable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name="id_customer", nullable = false)
    private Customer customer;

    @Column
    private String order_date;

    @Column
    private String status;
    
}
