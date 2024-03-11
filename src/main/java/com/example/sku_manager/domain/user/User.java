package com.example.sku_manager.domain.user;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;
    @Column(name = "accesslevel")
    private String accesslevel;


    public User(String username, String email, String password, String accesslevel) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.accesslevel = accesslevel;
    }


}
