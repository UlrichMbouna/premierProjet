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
@Table(name ="commandes")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;

    @ManyToOne
    @JoinColumn(name = "id_employe", nullable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name="id_client", nullable = false)
    private Client client;

    @Column
    private String date_commande;

    @Column
    private String status;
    
}
