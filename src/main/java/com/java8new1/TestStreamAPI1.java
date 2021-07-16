package com.java8new1;

import javafx.beans.binding.IntegerBinding;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStreamAPI1 {
    List<pojo> pojos = Arrays.asList(
            new pojo("z",18),
            new pojo("x",19),
            new pojo("x",18),
            new pojo("c",20),
            new pojo("c",27),
            new pojo("cc",27),
            new pojo("ccc",27),
            new pojo("cccc",27)

    );
    @Test
    public void method1(){
        boolean b = pojos.stream()
                .allMatch(pojo -> pojo.getAge().equals(18));
        System.out.println(b);
        boolean b1 = pojos.stream()
                .anyMatch(pojo -> pojo.getAge().equals(18));
        System.out.println(b1);
        boolean b2 = pojos.stream()
                .noneMatch(pojo -> pojo.getAge().equals(18));
        System.out.println(b2);
        Optional<pojo> first = pojos.stream()
                .findFirst();
        System.out.println(first);
        System.out.println(pojos.stream()
                .count());
        pojos.stream().max((o1, o2) -> o1.getAge());
    }
    @Test
    public void method2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .map(x -> x * x)
                .forEach(System.out::println);
    }
    @Test
    public void method3(){
        Optional<pojo> first = pojos.stream()
                .sorted((o1, o2) -> Double.compare(o1.getAge(), o2.getAge()))
                .findFirst();
        System.out.println(first);
        Optional<pojo> any = pojos.parallelStream()
                .filter(pojo -> pojo.getAge()>18)
                .findAny();
        System.out.println(any);
        long count = pojos.stream()
                .count();
        System.out.println(count);
        Optional<pojo> max = pojos.stream()
                .max((o1, o2) -> Double.compare(o1.getAge(), o2.getAge()));
        System.out.println(max);
        Optional<pojo> min = pojos.stream()
                .min((o1, o2) -> Double.compare(o1.getAge(),o2.getAge()));
        System.out.println(min);
        Optional<Integer> max1 = pojos.stream()
                .map(pojo::getAge)
                .max(Double::compare);
        System.out.println(max1);
    }
    @Test
    public void method5(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce1 = list.stream()
                .reduce(Integer::max);
        System.out.println(reduce1.get());
        System.out.println(list.stream()
                .reduce(0, (integer, integer2) -> integer + integer2));
        Optional<Integer> reduce = pojos.stream()
                .map(pojo::getAge)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }
    @Test
    public void method6(){
        System.out.println(pojos.stream()
                .map(pojo::getName)
                .collect(Collectors.toList()));
        //去重用set手机
        System.out.println(pojos.stream()
                .map(pojo::getName)
                .collect(Collectors.toSet()));
        //hashSet
        HashSet<String> collect = pojos.stream()
                .map(pojo::getName)
                .collect(Collectors.toCollection(HashSet::new));
        collect.forEach(System.out::println);

    }
    @Test
    public void method7(){
        //总数
        System.out.println(pojos.stream()
                .collect(Collectors.counting()));
        //总和
        System.out.println(pojos.stream()
                .collect(Collectors.summingInt(pojo::getAge)));
        //平均值
        System.out.println(pojos.stream()
                .collect(Collectors.averagingInt(pojo::getAge)));
        //最大值
        System.out.println(pojos.stream().max((o1, o2) -> Double.compare(o1.getAge(), o2.getAge())));
        //最小值
        System.out.println(pojos.stream()
                .collect(Collectors.minBy((o1, o2) -> Double.compare(o1.getAge(), o2.getAge()))));
        //分组
        System.out.println(pojos.stream()
                .collect(Collectors.groupingBy(pojo::getAge)));
        //多级分组
        Map<String, Map<Object, List<pojo>>> collect = pojos.stream()
                .collect(Collectors.groupingBy(pojo::getName, Collectors.groupingBy(pojo -> {
                    if (pojo.getAge() < 19) {
                        return "青年";
                    } else  {
                        return "中年";
                    }
                })));
        System.out.println(collect);
        //分区
        System.out.println(pojos.stream()
                .collect(Collectors.partitioningBy(pojo -> pojo.getAge() > 20)));
        //summarizingDouble
        DoubleSummaryStatistics collect1 = pojos.stream()
                .collect(Collectors.summarizingDouble(pojo::getAge));
        collect1.getAverage();
        collect1.getMax();
        collect1.getMin();
        collect1.getSum();
        collect1.getCount();
        //链接
        System.out.println(pojos.stream()
                .map(pojo::getName)
                .collect(Collectors.joining(",", "--", "**")));

    }

}
