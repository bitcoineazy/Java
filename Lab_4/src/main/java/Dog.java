package main.java;

public class Dog extends Mammal {

    @Override
    public void eat() {
        System.out.println("Dogs eat meat");
    }

    @Override
    public void talk() {
        System.out.println("Dogs talk");
    }

    @Override
    public void feed() {
        System.out.println("Dogs feed each other");
    }

    @Override
    public void move() {
        System.out.println("Dogs move");
    }

    @Override
    public void breed() {
        System.out.println("Dogs make children");
    }

}
