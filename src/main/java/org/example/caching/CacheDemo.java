package org.example.caching;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheDemo {
    public static void main(String[] args) throws ExecutionException {
        // Create a cache using CacheBuilder
        Cache<String, Integer> cache = CacheBuilder.newBuilder()
                .maximumSize(100)            // Maximum cache size
                .expireAfterWrite(1, TimeUnit.HOURS)  // Cache entries expire after 1 hour
                .recordStats()
                .build();

        // Put values into the cache
        cache.put("one", 1);
        cache.put("two", 2);
        cache.put("three", 3);
        cache.put("nine",9);

        // Retrieve values from the cache
        System.out.println("Value for 'one': " + cache.getIfPresent("one")); // 1
        System.out.println("Value for 'four': " + cache.getIfPresent("four")); // null (not in cache)

        // You can also use a loader function for automatic value loading if not present
        System.out.println("Value for 'five': " + cache.get("five", () -> 5)); // 5 (loaded using the provided function)

        System.out.println("Value for 'nine': " + cache.getIfPresent("nine"));
        cache.invalidate("nine");
        System.out.println("Value for 'nine': " + cache.getIfPresent("nine"));

        // Check cache statistics
        System.out.println("Cache Stats: " + cache.stats());


    }

    private static Integer loadValueFromDataSource(String key) {
        // This could involve a database query, computation, or other data retrieval logic
        System.out.println("Loading value for '" + key + "' from the data source.");
        return key.length();
    }
}
