package org.example.collections;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;

import java.util.Collection;
import java.util.Map;

public class MapsDemo {
    public static void main(String[] args){
        // immutable map creation
        fun1();

        // filtering
        fun2();

        // Bidirectional map
        fun3();

        // Multimap
        fun4();
    }

    private static void fun4() {
        Multimap<String, Integer> scores = ArrayListMultimap.create();
        scores.put("Alice", 95);
        scores.put("Alice", 98);
        scores.put("Bob", 88);

        Collection<Integer> aliceScores = scores.get("Alice");  // Returns [95, 98]
        System.out.println("Alice Scores : "+aliceScores);
    }

    private static void fun3() {
        BiMap<String, Integer> nameToId = HashBiMap.create();
        nameToId.put("Alice", 1);
        nameToId.put("Bob", 2);

        String res = nameToId.inverse().get(1);  // Returns "Alice"

        System.out.println("Difference : "+res);
    }

    private static void fun2() {
        Map<String, Integer> ages = ImmutableMap.of("Alice", 25, "Bob", 30, "Charlie", 35);

        Predicate<Map.Entry<String, Integer>> isAdult = entry -> entry.getValue() >= 18;

        Map<String, Integer> adults = Maps.filterEntries(ages, isAdult);
        System.out.println("Adults : "+adults);
    }

    private static void fun1() {
        Map<String, Integer> ages = ImmutableMap.of("Alice", 25, "Bob", 30, "Charlie", 35);
        ages.put("Pink",43);
    }
}
