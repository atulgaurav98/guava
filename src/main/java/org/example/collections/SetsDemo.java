package org.example.collections;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;

import java.util.Set;

public class SetsDemo {

    public static void main(String[] args){
        // immutable set creation
        fun1();

        // union and intersection of set
        fun2();

        // filtering
        fun3();

        // difference between sets
        fun4();

        // creation of immutable sorted set
        fun5();
    }

    private static void fun5() {
        ImmutableSortedSet<Integer> sortedSet = ImmutableSortedSet.of(4, 2, 6, 1, 3, 5);
        System.out.println("Sorted set : "+ sortedSet);
    }

    private static void fun4() {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
        Set<Integer> set2 = Sets.newHashSet(4, 5, 6, 7, 8);

        Set<Integer> difference = Sets.difference(set1, set2);  // {1, 2, 3}

        System.out.println("Difference : "+difference);
        }

    private static void fun3() {
        Set<Integer> numbers = Sets.newHashSet(1, 2, 3, 4, 5);

        Predicate<Integer> isEven = input -> input % 2 == 0;

        Set<Integer> evenNumbers = Sets.newHashSet(Collections2.filter(numbers, isEven));
        System.out.println("Even numbers : "+evenNumbers);
    }

    private static void fun2() {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> set2 = Sets.newHashSet(2, 3, 4);

        Set<Integer> intersection = Sets.intersection(set1, set2);  // {2, 3}
        Set<Integer> union = Sets.union(set1, set2);  // {1, 2, 3, 4}
        System.out.println("Union : "+union);
        System.out.println("Intersection : "+intersection);
    }

    private static void fun1() {
        Set<String> colors = ImmutableSet.of("Red", "Green", "Blue");
//        colors.add("Pink");
    }
}
