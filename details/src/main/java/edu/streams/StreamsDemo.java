package edu.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String... args) {

        Set<String> f = Stream.of("Alice", "Bob", "Charlie")
                .map(a->a.split(""))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        System.out.println(f);

        Integer max = Stream.of(1,2,8,4,5).mapToInt(a->a).max().getAsInt();


        OptionalDouble avg = Stream.of(1,2,40,4,5).filter(a->a>3).mapToInt(a->a).average();
        if (avg.isPresent()){
            System.out.println(avg.getAsDouble());
        } else {
            System.out.println("average wasn't  found ");
        }

    }

    public static void main1(String... args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("-----");

        names.stream().forEach(
                (a) -> {
                    System.out.println(a);
                }
        );

        System.out.println("-----");

        List<Integer> res = names.stream()
                .filter(a -> a.length() >= 3)
                .map((a) -> {
                    return a.length();
                })
                .collect(Collectors.toList());

        res.forEach(System.out::println);
        names.forEach(System.out::println);

        System.out.println("------FIND FIRST EXAMPLE ----");

        Optional<Integer> res1 = names.stream()
                .map((a) -> {
                    System.out.println("mapping -> " + a);
                    return a.length();
                })
                .filter(a -> a >= 10)
                .findFirst();

        System.out.println(res1.isPresent());
        System.out.println(res1.orElse(100500));

        System.out.println("------FIND FIRST WITH ELSE  ----");

        Integer fi = names.stream()
                .map((a) -> {
                    System.out.println("mapping -> " + a);
                    return a.length();
                })
                .filter(a -> a >= 10)
                .findFirst().orElse(0);
        System.out.println(fi);

/*
        System.out.println("----------");

        names.stream().map((a)-> a.toUpperCase())
                .map(String::toLowerCase)
                .forEach(System.out::println);
*/


    }
}
