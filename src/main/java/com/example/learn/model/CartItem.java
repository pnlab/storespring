package com.example.learn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Basic
    private Integer id;

    @Basic
    private Integer quantity;


    @ManyToOne
    @JoinColumn(name = "", referencedColumnName = "id")
    private Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "", referencedColumnName = "id")
    private User user;

}