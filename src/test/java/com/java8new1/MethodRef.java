package com.java8new1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

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
    @Test
    public void method8(){
//        Function<Integer,pojo> fun = pojo::new;
//        pojo apply = fun.apply(18);
//        System.out.println(apply);
    }
    @Test
    public void method9(){
        BiFunction<String,Integer,pojo> bf = pojo::new;
        pojo zhangsan = bf.apply("zhangsan", 18);
        System.out.println(zhangsan);

    }
    @Test
    public void method10(){
        Function<Integer,String[]> fun = String[]::new;

    }
    @Test
    public void method11(){
        Function<String,String> fun = s -> s.toUpperCase();
        String abc = fun.apply("abc");
        System.out.println(abc);
        Function<String,String> fun1 = s -> s.substring(2,5);
        String apply = fun1.apply("sdadasdsa");
        System.out.println(apply);
        BiFunction<Integer,Integer,Integer> fun2 =(o1, o2) -> o1+o2;
        Integer apply1 = fun2.apply(1, 2);
        System.out.println(apply1);
        BiFunction<Integer,Integer,Integer> fun3 =(o1,o2)-> o1 * o2;
        Integer apply2 = fun3.apply(1, 2);
        System.out.println(apply2);

    }
}
