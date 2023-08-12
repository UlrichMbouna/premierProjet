package com.example.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.OrderLine;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name ="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;

    @ManyToOne
    @JoinColumn(name = "id_employe", nullable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name="id_customer", nullable = false)
    private Customer customer;

    @Column
    private String order_date;

    @Column
    private String status;

    @ElementCollection
    List <OrderLine> orderLines;
    
    /*void addNewLine(Product product, double qte, double discount){
        //this.orderLines.add(new OrderLine((product, qte, discount));
        getOrderLines().add(new OrderLine(product, qte, discount));
    }

    //.getOrderLines().add(new OrderLine(product, qte, discount))

    double getTotalAmountDiscount(){

        double sum = 0;

        for(OrderLine orderLine : orderLines){
            sum = sum + orderLine.getLineAmountDiscount();
        }
        return sum;
    }

    double getTotalAmountWithDiscount(){

        double sum = 0;

        for(OrderLine orderLine : orderLines){
            sum = sum+ orderLine.getLineAmountWithDiscount();
        }
        return sum;        
        
    }

    double getTotalAmountNoDiscount(){

        double sum = 0;

        for(OrderLine orderLine : orderLines){
            sum = sum+ orderLine.getLineAmountNoDiscount();
        }
        return sum;
    }
    */
}
