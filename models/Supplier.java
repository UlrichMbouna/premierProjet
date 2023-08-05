package com.example.demo.models;

// import javax.persistence.*; // for Spring Boot 2
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
@Table(name = "suppliers")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id;

	@Column(name = "nom")
	@Getter @Setter private String nom;

    @Column(name = "address")
	@Getter @Setter private String address;

	@Column(name = "email")
	@Getter @Setter private String email;

	@Column(name = "status")
	@Getter @Setter private String status;

    @Column(name = "phone")
	@Getter @Setter private int phone;

	
}