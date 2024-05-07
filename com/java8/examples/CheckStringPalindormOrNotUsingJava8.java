package com.java8.examples;

import java.util.stream.IntStream;

public class CheckStringPalindormOrNotUsingJava8 {

    public static void main(String[] args) {
        String str = "aba";
        boolean flag = isGivenStringPlaindromeOrNot(str);

        System.out.println("Given string : "+str+"| Is plaindrome flag: "+flag);
    }

    public static boolean isGivenStringPlaindromeOrNot(String str){

        return IntStream
                .range(0, str.length()/2)
                .noneMatch(i-> str.charAt(i)!=str.charAt(str.length()-1));
    }
}
