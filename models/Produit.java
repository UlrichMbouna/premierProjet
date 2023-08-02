package com.example.demo.models;
// import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*; // for Spring Boot 3
import lombok.Getter;
import lombok.Setter;

    @Entity
    @Table(name = "produits")
    public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter private long id_produit;

	//@column(name="id_fournisseur")
	@ManyToOne
    @JoinColumn(name = "id_fournisseur", nullable = false)
	//@JsonIgnore
	@Getter @Setter private Fournisseur fournisseur;


    @Column(name = "marque")
	@Getter @Setter private String marque;

	@Column(name = "nom")
	@Getter @Setter private String nom;

	@Column(name = "image")
	//@JsonIgnore permet de ne pas afficher l element dans la reponse requete  c est a dire au moment de la serialisation
	@Getter @Setter private String image;
    
    @Column(name = "description")
	@Getter @Setter private String description;

    @Column(name = "prix")
	@Getter @Setter private double prix;

	public Produit(){
		
	}


	public Produit(String nom,Fournisseur fournisseur, String image,String marque, String description,double prix) {
		this.nom = nom;
		this.fournisseur=fournisseur;
		this.image =image;
		this.marque =marque;
        this.description=description;
        this.prix=prix;
	}

	

	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit  + "fournisseur="+ fournisseur.getId_fournisseur() + ", nom=" + nom + ", image=" + image+ ",marque=" + marque + ",description="+description+",prix="+prix+" ]";
	}
}
