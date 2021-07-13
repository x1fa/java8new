package com.java8new1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class functionInter {
    public static void main(String[] args) {
        //
        ha(100,v -> System.out.println("gnam"+100));
        //
        List<Integer> listt = gj(10, () -> (int) (Math.random()*100));
        for (Integer integer : listt) {
            System.out.println(integer);
        }
        //
        String hs = hs("\t\t\t到家街道街道", s -> s.substring(2,5).trim());
        System.out.println(hs);
        //
        List<String> stringList = Arrays.asList("hello","ategusm","www","lambda","ok");
        List<String> dy = dy(stringList, s -> s.length() > 3);
        for (String s : dy) {
            System.out.println(s);
        }
        stringList.stream().filter(s -> s.length()>=3).limit(2).forEach(s -> System.out.println(s));
    }
    //断言型接口 将满足条件的字符串放入集合中
    public static List<String> dy(List<String> str, Predicate<String> pre){
     List<String> list = new ArrayList<>();
        for (String s : str) {
            if (pre.test(s)){
                list.add(s);
            }
        }
     return list;
    }

    //函数型
    public static String hs(String str, Function<String,String> fun){
        return fun.apply(str);
    }
    //供给型
    public static List<Integer> gj(Integer iin, Supplier<Integer> ss){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <iin; i++) {
            Integer mu = ss.get();
            list.add(mu);
        }
        return list;
    };
    //消费性
    public static void ha(double m , Consumer<Double> c){
        c.accept(m);
    }
}
