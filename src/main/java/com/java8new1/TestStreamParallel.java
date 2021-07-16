package com.java8new1;

import com.java8new1.inter.FuInter;
import com.java8new1.inter.Test01;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.LongStream;

public class TestStreamParallel {
    @Test
    public void method() {
        Instant now = Instant.now();
        LongStream.rangeClosed(0, 10L)
                .parallel()
                .reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(now, end).toMillis());

    }

    @Test
    public void method1() {
        Optional<pojo> pojo = Optional.of(null);
        System.out.println(pojo.get());
    }

    @Test
    public void method2() {
        Test01 test01 = new Test01();
        test01.method();
        FuInter.method1();
    }

    @Test
    public void method3() {
        //创建本地时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getHour());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getMonth());
        System.out.println(now.getNano());
        //添加两天
        System.out.println(now.plusDays(2));
        //减去两天
        System.out.println(now.minusDays(2));

    }

    //时间戳
    @Test
    public void method5() {
        Instant start = Instant.now();
        System.out.println(Instant.now().toString());
        System.out.println(Instant.now());
        Instant end = start.plusMillis(10);
        Instant end1 = start.minusMillis(10);
        System.out.println(Duration.between(end1, end).toMillis());
        System.out.println(Duration.between(start, end).toMillis());
    }

    @Test
    public void method6() {
        //获取所有时区
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        //获取当前时区
        System.out.println(ZoneId.systemDefault().toString());
    }

    @Test
    public void method8() {
        //Date  --> Instant --> LocalDateTime
        System.out.println(new Date().toInstant());

        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        //LocalDateTime --> Instant --> Date
        //LocalDateTime 转 Instant 先确定时区 再 toInstant
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        //Instant 转 Date
        System.out.println(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
    }
    @Test
    public void method9(){
        //时间格式化字符串
        DateTimeFormatter basicIsoDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(basicIsoDate.format(LocalDateTime.now()));
        //字符串解析成时间
        System.out.println(LocalDateTime.parse("2021/07/15 16:36:25", basicIsoDate));
    }
}
