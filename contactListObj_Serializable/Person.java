package com.example.mark.myapplication;

import java.io.Serializable;

/**
 * Created by Mark on 10/20/2016.
 */

public class Person implements Serializable{
    private String name;
    private String phone;
    private Integer age;

    public Person(String name, String phone, Integer age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public String getPhone() {
        return phone;
    }


    public Integer getAge() {
        return age;
    }

}
