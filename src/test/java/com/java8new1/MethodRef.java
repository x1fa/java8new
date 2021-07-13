package com.java8new1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodRef {
    @Test
    public void method1(){
        Consumer<String> con = System.out::println;
        con.accept("是撒旦教偶埃及的");
    }
    @Test
    public void method2(){
        pojo pojo = new pojo("张三",18);
        Supplier<Integer> sup = pojo::getAge;
        Integer integer = sup.get();
        System.out.println(integer);
        Supplier<String> supp = () -> pojo.getName();
        String s = supp.get();
        System.out.println(s);

    }
    @Test
    public void method3(){
        pojo pojo = new pojo();
        test22<Integer> test22 = pojo::getAge;
        Integer na = test22.na();
        System.out.println(na);
    }
    @Test
    public  void method5(){
        Comparator<Integer> com = Integer::compareTo;
        com.compare( 1, 2);

    }
    @Test
    public void method6(){
        BiPredicate<String,String> biPredicate = String::equals;
        boolean test = biPredicate.test("dada", "sdadas");
        System.out.println(test);
    }
    @Test
    public void method7(){
        Supplier<pojo> sup = pojo::new;
        pojo pojo = sup.get();
        pojo.setAge(18);

        System.out.println(pojo);
    }

}
