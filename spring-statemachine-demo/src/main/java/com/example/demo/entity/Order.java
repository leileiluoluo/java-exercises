package com.example.demo.entity;

import com.example.demo.enums.OrderStates;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private OrderStates state;
    private Date createdAt;
    private Date updatedAt;

}
