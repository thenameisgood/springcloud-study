package com.wang.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/22 18:40
 */

public class Product {
    private String name;
    private String age;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(age, product.age) && Objects.equals(date, product.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, date);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", date=" + date +
                '}';
    }

    public Product(String name, String age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Product() {
    }
}

