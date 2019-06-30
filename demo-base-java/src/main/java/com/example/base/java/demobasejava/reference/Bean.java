package com.example.base.java.demobasejava.reference;

/**
 * @author benjamin
 * created at 2019/6/29
 */
public class Bean {
    private String name;
    private int age;

    public Bean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println("bean finalize >>> " + toString());
    }
}
