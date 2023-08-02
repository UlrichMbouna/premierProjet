package com.example.demo.models;

// import javax.persistence.*; // for Spring Boot 2
import jakarta.persistence.*; // for Spring Boot 3
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fournisseurs")
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id_fournisseur;

	@Column(name = "nom")
	@Getter @Setter private String nom;

    @Column(name = "address")
	@Getter @Setter private String address;

	@Column(name = "email")
	@Getter @Setter private String email;

	@Column(name = "status")
	@Getter @Setter private String status;

    @Column(name = "telephone")
	@Getter @Setter private int telephone;

	public Fournisseur(){
		
	}


	public Fournisseur(String nom, String address, String email,String status,int telephone) {
		this.nom = nom;
		this.address = address;
		this.email =email ;
        this.status=status;
        this.telephone=telephone;
	}

	

	@Override
	public String toString() {
		return "Fournisseur [id_fournisseur=" + id_fournisseur + ", nom=" + nom + ", email=" + email+ ",address=" + address + ",status="+status+",telephone="+telephone+" ]";
	}
}