package com.example.springbootmydemo;

import com.example.springbootmydemo.domain.GsonBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.scene.effect.Light;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        String x = list.toString();
//        System.out.println(x);


        Type type = new TypeToken<List<GsonBean>>() {
        }.getType();



        // [{"name":"bai","age":10},{"name":"bai","age":10}]
        System.out.println(gson.toJson(list, type));

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

//        ArrayList<GsonBean> list = gson.fromJson(jsonList, type);
//
//        System.out.println(list.toString());



    }

    /*


    com.google.gson.JsonSyntaxException: java.lang.NumberFormatException: For input string: "bai"


     */
}
