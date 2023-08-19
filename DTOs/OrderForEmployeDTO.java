package com.example.demo.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class OrderForEmployeDTO {
    
    @Getter @Setter private long  orderId;

    @Getter @Setter private String employeName;

    @Getter @Setter private Long customerId;

    @Getter @Setter private String customerName;

    @Getter @Setter List <Long> supplierId;

    @Getter @Setter List <String> nameSupplier;

    @Getter @Setter List <Integer> stockProductQuantity;

    @Getter @Setter List <Double> orderLineQuantity;

	@Getter @Setter List <Double>  height;

	@Getter @Setter List <Double>  width;

	@Getter @Setter List <Double>  oZ;
	
	@Getter @Setter List <Double>  weight;

	@Getter @Setter List <String>  color;

    @Getter @Setter List <String> productName;

    @Getter @Setter List <Double> productPrice;

    @Getter @Setter List <Double> oderLinePrice;

    @Getter @Setter List <Double> weightOrderLine;

    @Getter @Setter private String orderDate;

    @Getter @Setter private String status;

     @Getter @Setter private String addressLivraison;


}
