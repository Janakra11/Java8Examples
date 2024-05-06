package com.java8.examples;

import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharacterCountFromString {

    public static void main(String[] args) {

        String str = "Janakraj";

        Map<Character, Long> characterCountMap = characterCountInGivenStringUsingJava8(str);

        System.out.println(characterCountMap);

    }

    public static Map<Character, Long> characterCountInGivenStringUsingJava8(String str){

        return str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }
}
