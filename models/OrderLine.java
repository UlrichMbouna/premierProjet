package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
public class OrderLine {

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @Column
    @Getter @Setter private double quantity;

    @Column
    @Getter @Setter private double discount;

    
    public OrderLine(){}

    public OrderLine( double qte, double discount) {
    }

   /* public double getLineAmountNoDiscount(){
        return quantity * product.getPrice();
    }

    public double getLineAmountWithDiscount(){
        return quantity * product.getPrice() * (1 - discount);
    }

    public double getLineAmountDiscount(){
        return quantity * product.getPrice() * discount;
    }

    public void setProduct(Product product2) {
    }
    */ 
}
