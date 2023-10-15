package org.example.collections;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

public class ListsDemo {
    public static void main(String[] args){
        // Creating an Immutable List
        function1();

        // Concatenating Lists
        function2();

        // Partitioning a List
        function3();

        // Transforming a List
        function4();
        
        // Filtering a List
        function5();

    }

    private static void function5() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5);

        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input % 2 == 0;
            }
        };

        List<Integer> evenNumbers = Lists.newArrayList(Collections2.filter(numbers, isEven));

        System.out.println("Even Numbers : "+evenNumbers);

    }

    private static void function4() {
        List<String> words = Lists.newArrayList("apple", "banana", "cherry");

        Function<String, String> capitalize = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input.substring(0, 1).toUpperCase() + input.substring(1);
            }
        };

        List<String> capitalizedWords = Lists.transform(words, capitalize);
        System.out.println("Capitalized words : "+capitalizedWords);
    }

    private static void function3() {
        List<String> names = Lists.newArrayList("Alice", "Bob", "Charlie", "David", "Eve");

        List<List<String>> partitions = Lists.partition(names, 2);

        System.out.println("Partitioned lists : "+partitions);

    }

    private static void function2() {
        List<String> list1 = Lists.newArrayList("A", "B", "C");
        List<String> list2 = Lists.newArrayList("X", "Y", "Z");

        List<String> combinedList = Lists.newArrayList(Iterables.concat(list1, list2));
        System.out.println("Combined List : "+combinedList);
    }

    private static void function1() {
        ImmutableList<String> colors = ImmutableList.of("Red", "Green", "Blue");
//        colors.add(1,"ere"); // will throw UnsupportedOperationException
    }
}
