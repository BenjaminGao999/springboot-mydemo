package com.example.springbootmydemo;

import com.example.springbootmydemo.domain.GsonBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author benjamin
 * created at 2019/5/10
 */
public class GsonTest {

    @Test
    public void getInitJson() {

        ArrayList<Object> list = new ArrayList<>();


        for (int i = 0; i < 2; i++) {

            HashMap<String, Object> hashMap = new HashMap<>();

            hashMap.put("age", 10);
            hashMap.put("name", "bai");
            list.add(hashMap);
        }

        System.out.println(list.toString());


    }


    Gson gson = new Gson();

    String jsonList = " [{name=bai, age=10}, {name=bai, age=10}]";


    /*
    [{name=bai, age=10}, {name=bai, age=10}]
     */
    @Test
    public void deserializedJSONList() {
        Type type = new TypeToken<ArrayList<GsonBean>>() {
        }.getType();

        ArrayList<GsonBean> list = gson.fromJson(jsonList, type);

        System.out.println(list.toString());

    }

    /*


    com.google.gson.JsonSyntaxException: java.lang.NumberFormatException: For input string: "bai"


     */
}
