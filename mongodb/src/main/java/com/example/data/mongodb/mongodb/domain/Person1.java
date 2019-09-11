package com.example.data.mongodb.mongodb.domain;

/**
 * @author benjamin
 * created at 2019/9/11
 */
public class Person1 {

    private String id;
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person1 [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}

