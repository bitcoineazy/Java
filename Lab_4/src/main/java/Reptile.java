package main.java;

public abstract class Reptile implements Animal {
    @Override
    public void eat() {
        System.out.println("Reptiles eat");
    }

    @Override
    public void move() {
        System.out.println("Reptiles eat");
    }

    public abstract void talk();

    @Override
    public void feed() {
        System.out.println("Reptiles eat");
    }

    @Override
    public void breed() {
        System.out.println("Reptiles eat");
    }
}
