package Lecture_04;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyCollections {
    public static void main(String[] args) {


        Collection<Integer> collection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //1. Iterator
        Iterator<Integer> iter = collection.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        // For each
        for (Integer value : collection
        ) {
            System.out.print(value + " ");
        }
        System.out.println();
        //Stream API
        collection.stream()
                .forEach(value -> System.out.print(value + " "));
        System.out.println();
        collection.stream().forEach(System.out::print);
        ArrayList<Integer> list = new ArrayList<>(collection);
        list.add(11);
        list.get(5);
        list.contains(4);

    }


}
