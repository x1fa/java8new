package com.java8new1;

import lombok.*;

import java.util.Objects;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class pojo {
    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pojo pojo = (pojo) o;
        return Objects.equals(name, pojo.name) && Objects.equals(age, pojo.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public pojo(Integer age) {
        this.age = age;
    }

    public pojo(String name) {
        this.name = name;
    }

    public pojo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
