package com.design.pattern.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPattern {

    public static void sum(List<Integer> values, Predicate<Integer> predicate) {
        int total = values
                .stream()
                .filter(predicate)
                .reduce(0, Integer::sum);
        System.out.println("Total is : " + total);
    }

    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        sum(list, e -> true);
        sum(list, Util::isOdd);
        sum(list, Util::isEven);

    }
}

class Util {
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
