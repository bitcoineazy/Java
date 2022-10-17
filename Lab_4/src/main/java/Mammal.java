package main.java;

public abstract class Mammal implements Animal {

    public void eat() {
        System.out.println("Mammals eat food");
    };

    public void move() {
        System.out.println("Mammals move");
    };

    public void talk() {
        System.out.println("Mammals talk");
    };

    public void breed() {
        System.out.println("Mammals make children");
    };

    public void feed() {
        System.out.println("Mammals feed each other");
    };
}
