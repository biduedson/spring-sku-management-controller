package com.example.sku_manager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tb_product_withdrawals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithdrawals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    public  ProductWithdrawals(Date date,Integer quantity,Product product,User user ){
      this.date = date;
      this.quantity = quantity;
      this.product = product;
      this.user = user;

    }
}
