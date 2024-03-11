package com.example.sku_manager.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private   String name;
    private  String imgUrl;
    private  String properties;
    private Integer quantity;
    private Date date;
    private  String SKU;
    private String GTIN;

    public Product(String name, String imgUrl, String properties, Integer quantity, Date date, String SKU, String GTIN){
        this.name = name;
        this.imgUrl = imgUrl;
        this.properties = properties;
        this.quantity = quantity;
        this.date = date;
        this.SKU = SKU;
        this.GTIN = GTIN;
    }
}
