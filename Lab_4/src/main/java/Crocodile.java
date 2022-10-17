package main.java;

public class Crocodile extends Reptile {

    @Override
    public void eat() {
        System.out.println("Crocodiles eat meat");
    }

    @Override
    public void talk() {
        System.out.println("Crocodiles talk");
    }

    @Override
    public void feed() {
        System.out.println("Crocodiles feed each other");
    }

    @Override
    public void move() {
        System.out.println("Crocodiles move");
    }

    @Override
    public void breed() {
        System.out.println("Crocodiles make children");
    }
}
