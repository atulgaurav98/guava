package org.example.others;

import com.google.common.base.Preconditions;

public class PreconditionsDemo {
    public static void main(String[] args) {
        funPreconditions();
    }

    private static void funPreconditions() {
        int age = -5;

        Preconditions.checkArgument(age >= 0, "Age cannot be negative");

        // If the condition is not met, the checkArgument method throws an IllegalArgumentException.

        System.out.println("Age is: " + age);
    }


}
