package com.example.jpa.jap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @author benjamin
 * created at 2019/8/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotsApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void test() {
        System.out.println(dataSource.getClass());
    }


}

