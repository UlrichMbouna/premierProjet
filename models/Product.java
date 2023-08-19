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
	private long id_Product;

	//@OneToOne(mappedBy = "product")
	//private OrderLine orderLine;

	//@column(name="id_fournisseur")
	@ManyToOne
    @JoinColumn(name = "id_supplier", nullable = false)
	//@JsonIgnore
	private Supplier supplier;


    @Column(name = "mark")
	private String mark;

	@Column(name = "nom")
	private String nom;

	@Column(name = "picture")
	//@JsonIgnore permet de ne pas afficher l element dans la reponse requete  c est a
	// dire au moment de la serialisation
	private String picture;
    
    @Column(name = "description")
	private String description;

	@Column(name = "stockQuantity")
	private int stockQuantity;

	@Column(name = "height")
	private double height;

	@Column(name = "width")
	private double width;

	@Column(name = "oz")
	private double oZ;
	
	@Column(name = "weight")
	private double weight;

	@Column(name = "color")
	private String color;

    @Column(name = "price")
	private double price;

}
