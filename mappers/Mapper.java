package com.example.demo.mappers;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.List;

import com.example.demo.DTOs.OrderForCustomerDTO;
import com.example.demo.DTOs.OrderForEmployeDTO;
import com.example.demo.models.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;




@Component
public class Mapper {
    
    public OrderForCustomerDTO toDto(Order order ){


     long  orderId=order.getId();
     String employeName=order.getEmploye().getNom();
     String customerName=order.getCustomer().getNom();

     List<Double> orderLineQuantity = order.getOrderLines()
                                                .stream()
                                                .map(orderLine -> orderLine.getQuantity())
                                                .collect( Collectors.toList() );

     List<String> productNames= order.getOrderLines()
                                     .stream()
                                     .map( orderLine -> orderLine.getProduct().getNom()).collect(Collectors.toList());

     List<Double> productPrice= order.getOrderLines()
                                     .stream()
                                     .map( orderLine -> orderLine.getOrderLinePrice()).collect(Collectors.toList());

     String orderDate=order.getOrder_date();

     String status=order.getStatus();

     String addressLivraison = order.getAddressLivraison();

     return new OrderForCustomerDTO(orderId, employeName, customerName, orderLineQuantity, productNames, productPrice, orderDate, status, addressLivraison);

    }

    public OrderForEmployeDTO toDto1(Order order){

      long  orderId=order.getId();

      String employeName=order.getEmploye().getNom();

      long customerId= order.getCustomer().getId();

      String customerName= order.getCustomer().getNom();

      List <Long> supplierId=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getSupplier().getId())
                                                    .collect(Collectors.toList());

      List <String> nameSupplier= order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getSupplier().getNom())
                                                    .collect(Collectors.toList());

      List <Integer> stockProductQuantity=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getStockQuantity())
                                                    .collect(Collectors.toList());

      List <Double> orderLineQuantity=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getQuantity())
                                                    .collect(Collectors.toList());

	  List <Double>  height=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getHeight())
                                                    .collect(Collectors.toList());

	  List <Double>  width =order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getWidth())
                                                    .collect(Collectors.toList());

	  List <Double>  oZ= order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getOZ())
                                                    .collect(Collectors.toList());
	
	  List <Double>  weight=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getWeight())
                                                    .collect(Collectors.toList());

	  List <String>  color=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getColor())
                                                    .collect(Collectors.toList());

      List <String> productName=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getNom())
                                                    .collect(Collectors.toList());

      List <Double> productPrice=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getProduct().getPrice())
                                                    .collect(Collectors.toList());

      List <Double> oderLinePrice=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getOrderLinePrice())
                                                    .collect(Collectors.toList());

      List <Double> weightOrderLine=order.getOrderLines().stream()
                                                    .map(orderline->orderline.getWeithOderLine())
                                                    .collect(Collectors.toList());

      String orderDate=order.getOrder_date();

      String status=order.getStatus();

       String addressLivraison=order.getAddressLivraison();

       return new OrderForEmployeDTO(orderId, employeName, customerId, customerName, supplierId, nameSupplier, stockProductQuantity, orderLineQuantity, height, width, oZ, weight, color, productName, productPrice, oderLinePrice, weightOrderLine, orderDate, status, addressLivraison);
    }

}
