package com.example.querydsl.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.querydsl.entity.QFoodStore;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodRController {

    private final JPAQueryFactory query;

    @GetMapping("/{param}")
    public ResponseEntity paramCehck(
            @PathVariable String param) {
        return ResponseEntity.ok(param);
    }

    @GetMapping("/")
    public ResponseEntity findAll() {
        QFoodStore foodStore = QFoodStore.foodStore;
        List<Tuple> result = query.select(foodStore.id, foodStore.rate, foodStore.ownerName)
                .from(foodStore)
                .fetch();
        return ResponseEntity.ok(result);
    }
}
