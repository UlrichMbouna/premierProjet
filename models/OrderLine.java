package com.example.demo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Embeddable
public class OrderLine {

    @ManyToOne
    @JoinColumn(name = "id_product")
    @Getter private Product product;

    @Column(name="quantity")
    @Getter @Setter private double quantity;

    @Column(name="discount")
    @Getter @Setter private double discount;

    
    public OrderLine(){}

    public OrderLine( double qte, double discount) {
    }

    public double getWeithOderLine(){
        return product.getWeight()*quantity;
    }

    public double getOrderLinePrice(){
        return product.getPrice()*quantity;
    }

   public double getLineAmountNoDiscount(){
        return quantity * product.getPrice();
    }

    public double getLineAmountWithDiscount(){
        return quantity * product.getPrice() * (1 - discount);
    }

    public double getLineAmountDiscount(){
        return quantity * product.getPrice() * discount;
    }

   
    
}
