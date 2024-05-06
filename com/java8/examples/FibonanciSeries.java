package com.java8.examples;

import java.util.stream.Stream;

public class FibonanciSeries {

    public static void main(String[] args) {

        int no = 12 ;

        System.out.println("Print fibonanci series till given no is "+no);
        printFibonanciSeriesTillGivenNo(no);
    }

    public static void printFibonanciSeriesTillGivenNo(int no){
        Stream.iterate(new int[]{0, 1}, fibo->new int[] {fibo[1], fibo[0]+fibo[1]})
                .limit(no)
                .map(n->n[0])
                .forEach(x->System.out.println(x));
    }
}
