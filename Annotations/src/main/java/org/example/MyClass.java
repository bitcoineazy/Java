package org.example;

public class MyClass {

    @Deprecated(since = "3.3", forRemoval = true)
    public void deprecatedMethod() {
        System.out.println("deprecatedMethod");
    }
}
