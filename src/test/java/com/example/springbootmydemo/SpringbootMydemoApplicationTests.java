package com.example.springbootmydemo;

import com.example.springbootmydemo.domain.Food;
import com.example.springbootmydemo.domain.SupperMarket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMydemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
    SupperMarket market;

	@Test
    public void autoInjectTest(){
        List<Food> foods = market.getFoods();

        System.out.println(Arrays.toString(foods.toArray()));
    }

}
