package com.java8new1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI {
    List<pojo> pojos = Arrays.asList(new pojo("z",18),
            new pojo("x",19),
            new pojo("x",19),
            new pojo("c",20),
            new pojo("c",20)
    );
    @Test
    public void method1(){
        Stream.iterate(0,integer -> integer+2)
                .limit(5)
                .forEach(System.out::println);
        Stream.generate(() -> Math.random()*100)
                .limit(5)
                .forEach(System.out::println);
    }
    @Test
    public void method2(){
    List<pojo> pojos = Arrays.asList(
            new pojo("z",18),
            new pojo("x",19),
            new pojo("x",18),
            new pojo("c",20),
            new pojo("c",27)
    );
    pojos.stream()
            .filter(x->{
                return x.getAge()>18;
            })
//            .limit(1)
            .skip(0)
            .distinct()
            .forEach(System.out::println);
    }
    @Test
    public void method3(){
        List<String> list =Arrays.asList("aabc","acbs","sdao");
        list.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
        pojos.stream()
                .map(pojo::toString)
                .forEach(System.out::println);
    }
    List<String> list =Arrays.asList("aabc","acbs","sdao");
    @Test
    public void method4(){
//        Stream<Stream<Character>> streamStream = list.stream().map(TestStreamAPI::filterStream);
//        streamStream.forEach(characterStream -> {
//            characterStream.forEach(System.out::println);
//        });
        list.stream()
                .flatMap(TestStreamAPI::filterStream)
                .forEach(System.out::println);
    }
    public static Stream<Character> filterStream(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void method5(){
        List<pojo> pojoss = Arrays.asList(
                new pojo("z",18),
                new pojo("x",19),
                new pojo("x",18),
                new pojo("c",20),
                new pojo("c",27)
        );
        pojoss.stream()
                .sorted((o1, o2) -> {
                    if (o1.getName().equals(o2.getName())){
                        return o1.getAge().compareTo(o2.getAge());
                    }else{
                         return o1.getName().compareTo(o2.getName());
                    }
                })
                .forEach(System.out::println);
    }

}
