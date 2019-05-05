package com.example.springbootmydemo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benjamin
 * created at 2019/5/5
 */
public class SupperMarket {

    private List<Food> foods;

    {
        if (foods == null) {
            synchronized (SupperMarket.class) {
                if (foods == null) {
                    foods = new ArrayList<>();
                }
            }
        }
    }

    public void addFood(Food food) {
        if (food != null)
            foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }
}
