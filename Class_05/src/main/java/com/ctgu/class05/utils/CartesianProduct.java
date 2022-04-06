package com.ctgu.class05.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CartesianProduct {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1", "4", "5");
        List<String> list2 = Arrays.asList("2", "6", "7");
        List<String> list3 = Arrays.asList("3", "8", "9");

        List<String> descartesList = descartes(list1, list2, list3);
        descartesList.forEach(System.out::println);
    }

    public static List<String> descartes(List<String>... lists) {
        List<String> tempList = new ArrayList<>();
        for (List<String> list : lists) {
            if (tempList.isEmpty()) {
                tempList = list;
            } else {
                tempList = tempList.stream().flatMap(item -> list.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
            }
        }
        return tempList;
    }
}