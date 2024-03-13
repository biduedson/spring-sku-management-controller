package com.example.sku_manager.domain;

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
    private Integer quantity;
    @Temporal(TemporalType.DATE)
    private Date date;
    private  String sku;
    private  String imgurl;
    private String gtin;
    private  String properties;

    public Product(String name,Integer quantity, Date date,  String sku,  String imgurl,   String gtin, String properties){
        this.name = name;
        this.imgurl = imgurl;
        this.quantity = quantity;
        this.date = date;
        this.sku = sku;
        this.gtin = gtin;
        this.properties = properties;
    }
}
