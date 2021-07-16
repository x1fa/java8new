package com.java8new1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestStreamAPIlianxi {
    List<pojo> pojos = Arrays.asList(
            new pojo("aa",18,"北京",1000),
            new pojo("bb",19,"上海",2000),
            new pojo("cc",20,"深圳",3000),
            new pojo("dd",21,"广州",4000),
            new pojo("ee",22,"杭州",5000)
    );
    //2011年 交易额 排序 低到高
    @Test
    public void method(){
        pojos.stream()
                .filter(pojo -> pojo.getAge()>19)
                .sorted((o1, o2) -> Double.compare(o1.getMoney(),o2.getMoney()))
                .forEach(System.out::println);
    }
    //交易员在那些城市工作过
    @Test
    public void method1(){
        pojos.stream()
                .map(pojo::getAddress)
                .forEach(System.out::println);
    }
    //来自 剑桥 的交易员 字母排序
    @Test
    public void method2(){
        pojos.stream()
                .filter(pojo -> pojo.getMoney()>2000)
                .map(pojo::getName)
                .sorted()
                .forEach(System.out::println);
    }
    //有没有在米兰工作的交易员
    @Test
    public void method3(){
        System.out.println(pojos.stream()
                .anyMatch(pojo -> pojo.getName() == "aa"));
    }
    //打印生活在剑桥的交易员的所有交易额
    @Test
    public void method5(){
        pojos.stream()
                .filter(pojo -> pojo.getAge()>19)
                .forEach(System.out::println);
    }
    //所有交易中 最高交易额是多少
    @Test
    public void method6(){
        System.out.println(pojos.stream()
                .max((o1, o2) -> Double.compare(o1.getMoney(), o2.getMoney())));

    }
    //交易额最小多少
    @Test
    public void method7(){
        System.out.println(pojos.stream()
                .min((o1, o2) -> Double.compare(o1.getMoney(), o2.getMoney())));
    }
}
