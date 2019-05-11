package com.example.springbootmydemo.domain;

/**
 * @author benjamin
 * created at 2019/5/10
 */
public class GsonBean {

    private int age;
    private String name;

    private String score;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "GsonBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
