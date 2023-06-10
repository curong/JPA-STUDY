package com.example.querydsl.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_type_id")
    private Integer pid;

    private String foodTypeName;
    private int foodOrder;

    @OneToMany(mappedBy = "foodType")
    @ToString.Exclude
    List<FoodStore> foodStoreList = new ArrayList<>();

    public FoodType(String foodTypeName, int foodOrder) {
        this.foodTypeName = foodTypeName;
        this.foodOrder = foodOrder;
    }


}
