package com.example.querydsl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.querydsl.entity.FoodStore;
import com.example.querydsl.entity.FoodType;
import com.example.querydsl.entity.QFoodStore;
import com.example.querydsl.repository.FoodStoreRepository;
import com.example.querydsl.repository.FoodTypeRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
class QuerydslApplicationTests {

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    private FoodStoreRepository foodStoreRepository;

    @Autowired
    private JPAQueryFactory query;

    @Test
    public void setData() {

        FoodType korean = new FoodType("한식", 1);
        FoodType western = new FoodType("양식", 2);
        FoodType chinese = new FoodType("중식", 3);
        FoodType japanese = new FoodType("일식", 4);
        foodTypeRepository.saveAll(List.of(korean, western, chinese, japanese));

        FoodStore foodStore1 = new FoodStore(null, "삼겹살", 9, "kim", korean);
        FoodStore foodStore2 = new FoodStore(null, "닭갈비", 2, "kang", korean);
        FoodStore foodStore3 = new FoodStore(null, "부대찌개", 3, "jeong", korean);
        FoodStore foodStore4 = new FoodStore(null, "순대국밥", 4, "seong", korean);
        FoodStore foodStore5 = new FoodStore(null, "소고기", 5, "chae", korean);
        FoodStore foodStore6 = new FoodStore(null, "스파게티", 6, "park", western);
        FoodStore foodStore7 = new FoodStore(null, "피자", 7, "koo", western);
        FoodStore foodStore8 = new FoodStore(null, "중국집", 8, "min", chinese);
        FoodStore foodStore9 = new FoodStore(null, "훠거집", 9, "han", chinese);
        FoodStore foodStore10 = new FoodStore(null, "초밥집", 10, "kwon", japanese);

        foodStoreRepository.saveAll(
                List.of(
                        foodStore1,
                        foodStore2,
                        foodStore3,
                        foodStore4,
                        foodStore5,
                        foodStore6,
                        foodStore7,
                        foodStore8,
                        foodStore9,
                        foodStore10));

    }

    @Test
    public void query() {
        QFoodStore foodStore = QFoodStore.foodStore;
        List<FoodStore> result = query.selectFrom(foodStore).fetch();

        System.out.println(result.size());
    }

}
