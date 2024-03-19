package com.example.sku_manager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "advertised_products" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @Column(name = "advertise_link")
    private String advertiseLink;
    private Date publish_date;
    @ManyToOne
    @JoinColumn(name = "platform_id", referencedColumnName = "id")
    private Platform platform;

    public AdvertisedProduct(Product product, String advertiseLink, Date publish_date, Platform platform){
        this.product = product;
        this.advertiseLink = advertiseLink;
        this.publish_date = publish_date;
        this.platform = platform;
    }


}
