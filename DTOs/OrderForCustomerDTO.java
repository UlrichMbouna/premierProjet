package com.example.demo.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class OrderForCustomerDTO {
    
    @Getter @Setter private long  orderId;

   
    @Getter @Setter private String employeName;

    @Getter @Setter private String customerName;

    @Getter @Setter List <Double> orderLineQuantity;

    @Getter @Setter List <String> productName;

    @Getter @Setter List <Double> productPrice;

    @Getter @Setter private String orderDate;

    @Getter @Setter private String status;

    @Getter @Setter private String addressLivraison;

   

}
