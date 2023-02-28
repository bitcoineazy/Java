package org.example;


import java.util.ArrayList;

public class Main {
    public static <T extends ClassA> void printClass(T obj) {
        System.out.println(obj.getClass().toGenericString());

    }
    public static void test2 (ArrayList<? super ClassC> objects) {

    }
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        //MyGenericClass<ClassA> myGenericClass = new MyGenericClass<>(new ClassA());
        MyGenericClass2<ClassD> ex = new MyGenericClass2<>(new ClassD());

        //ArrayList<ClassB> list = new ArrayList<>();
        //list.add(new ClassB());
        //list.add(new ClassC());
        //list.add(new ClassD());

        //ArrayList<ClassD> list2 = new ArrayList<>();
        //list2.add(new ClassD());
        ArrayList list3 = new ArrayList();
        list3.add(new ClassA());
        list3.add(new ClassC());
        list3.add("123123");
        list3.add(5);
        System.out.println(list3);
        printClass(new ClassC());

    }
}