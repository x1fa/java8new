package com.java8new1;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.*;

import java.util.Objects;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class pojo {
    private String name;
    private Integer age;
    private String address;
    private Integer money;



    public pojo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
//
//    public pojo() {
//    }
//
//    public pojo(String name, Integer age, String address, Integer money) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//        this.money = money;
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pojo pojo = (pojo) o;
        return Objects.equals(name, pojo.name) && Objects.equals(age, pojo.age) && Objects.equals(address, pojo.address) && Objects.equals(money, pojo.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address, money);
    }
}
