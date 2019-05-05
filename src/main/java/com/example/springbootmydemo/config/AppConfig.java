package com.example.springbootmydemo.config;

import com.example.springbootmydemo.domain.Bread;
import com.example.springbootmydemo.domain.Food;
import com.example.springbootmydemo.domain.SupperMarket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author benjamin
 * created at 2019/5/5
 */
@Configuration
public class AppConfig {

    @Bean
    public SupperMarket supperMarket(Food food) {
        SupperMarket market = new SupperMarket();
        market.addFood(food);

        return market;
    }

    @Bean
    public Food food() {
        return new Bread();
    }

}
