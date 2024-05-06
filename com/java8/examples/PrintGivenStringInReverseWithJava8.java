package com.java8.examples;

public class PrintGivenStringInReverseWithJava8 {

    public static void main(String[] args) {

        String str="Janakraj Raosaheb Khatal";
        String reverseStr = reverseStringUsingJava8(str);

        System.out.println("Given string is "+ str);
        System.out.println("Given input reverse string is "+ reverseStr);
    }

    public static String reverseStringUsingJava8(String str){
        return str.chars()
                .mapToObj(c->(char)c)
                .reduce("", (s,c)->c+s, (s1, s2)-> s2+s1);
    }
}
