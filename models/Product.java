package com.example.demo.models;
// import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*; // for Spring Boot 3
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
    @Table(name = "products")
    public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private long id_Product;

	//@OneToOne(mappedBy = "product")
	//private OrderLine orderLine;

	//@column(name="id_fournisseur")
	@ManyToOne
    @JoinColumn(name = "id_supplier", nullable = false)
	//@JsonIgnore
	@Getter @Setter private Supplier supplier;


    @Column(name = "mark")
	@Getter @Setter private String mark;

	@Column(name = "nom")
	@Getter @Setter private String nom;

	@Column(name = "picture")
	//@JsonIgnore permet de ne pas afficher l element dans la reponse requete  c est a dire au moment de la serialisation
	@Getter @Setter private String picture;
    
    @Column(name = "description")
	@Getter @Setter private String description;

    @Column(name = "price")
	@Getter @Setter private double price;

	}
