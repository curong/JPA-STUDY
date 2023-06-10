package com.example.querydsl.repository;

import com.example.querydsl.entity.FoodStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodStoreRepository extends JpaRepository<FoodStore, Integer> {
}
