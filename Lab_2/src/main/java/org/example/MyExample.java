package org.example;

import java.util.Scanner;

class Person
{
    /*
    статическая переменная который существуют в одном экземпляре
    и обращаться к ним нужно по имени класса
    (внутри класса к статической переменной можно обращаться просто по имени).
    В этом случае переменная подсчитывает количество экземпляров, созданных из этого
    класса.
    */
    private static int counter=0;
    private String name="";
    private int age;
    public Person()
    {
        counter++;
    }
    public Person(String name)
    {
        counter++;
        this.setName(name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public static int getCounter() {
        return counter;
    }
    public void print()
    {
        System.out.print("Name: "+name+"\n"+"Age: "+age+"\n");
    }
}

public class MyExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Printing person data: ");
        Person yuri=new Person("Yuri");
        yuri.setAge(25);
        yuri.print();
        System.out.print("Printing person data: ");
        Person alexey=new Person("Alexey");
        alexey.setAge(50);
        alexey.print();
        System.out.println("Number of people so far: "+Person.getCounter());
        byte varByte=55;
        int varInt=10;
        long varLong=789;
        double varDouble=1.675;
        float varFloat= 265.36f;
        char varChar='W';
        boolean varBoolean=false;
        String varString="";
        System.out.print("\nCurrent value of varByte is: "+varByte);
        System.out.print("\nEnter new value for varByte: ");
        varByte=in.nextByte();
        System.out.print("New value of varByte is: "+varByte);
        System.out.print("\n\nCurrent value of varInt is: "+varInt);
        System.out.print("\nEnter new value for varInt: ");
        varInt=in.nextInt();
        System.out.print("New value of varInt is: "+varInt);
        System.out.print("\n\nCurrent value of varLong is: "+varLong);
        System.out.print("\nEnter new value for varLong: ");
        varLong=in.nextLong();
        System.out.print("New value of varLong is: "+varLong);
        System.out.print("\n\nCurrent value of varDouble is: "+varDouble);
        System.out.print("\nEnter new value for varDouble: ");
        varDouble=in.nextDouble();
        System.out.print("New value of varDouble is: "+varDouble);
        System.out.print("\n\nCurrent value of varFloat is: "+varFloat);
        System.out.print("\nEnter new value for varFloat: ");
        varFloat=in.nextFloat();
        System.out.print("New value of varFloat is: "+varFloat);
        System.out.print("\n\nCurrent value of varChar is: "+varChar);
        System.out.print("\nEnter new value for varChar: ");
        varChar=in.next().charAt(0);
        System.out.print("New value of varChar is: "+varChar);
        System.out.print("\n\nCurrent value of varBoolean is: "+varBoolean);
        System.out.print("\nEnter new value for varBoolean: ");
        varBoolean=in.nextBoolean();
        System.out.print("New value of varBoolean is: "+varBoolean);

        System.out.print("\n\nCurrent value of varString is: "+varString);
        System.out.print("\nEnter new value for varString: ");
        varString=in.next();
        System.out.print("New value of varString is: "+varString);
        System.out.print("\n\nEntering 5 integers\n");
        int [] array=new int[5];
        for(int i=0;i<array.length;i++) {
            System.out.print("Enter value: ");
            array[i] = in.nextInt();
        }
        System.out.print("\n\nEnter 5 names\n");
        String [] names=new String[5];
        int i=0;
        while (i<names.length)
        {
            System.out.print("Enter name: ");
            names[i]=in.next();
            i++;
        }
        do {
            System.out.println("square of ["+array[i]+"] is "+Math.pow(array[i],2));
            System.out.println("square root of ["+array[i]+"] is "+Math.sqrt(array[i]));
        }while (i< array.length);
        int choice=-1;
        while (choice!=4) {
            System.out.print(
                    """
                    ================Main Menu Example =============
                    
                    1- print Hello message
                    2- print integer array
                    3- print names array
                    4- exit
                    """);
            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print(
                            """
                                                                
                                    Choose language
                                    1- Russian
                                    2- English
                                    """);
                    int lang = in.nextInt();
                    if (lang == 1) {

                        System.out.println("Добро пожаловать!");
                    } else if (lang == 2) {
                        System.out.println("Welcome!");
                    } else {
                        System.out.println("invalid input!");
                    }
                    break;
                }
                case 2 -> {
                    for (int k = 0; k < array.length; k++) {
                        System.out.print(array[k] + " ");

                    }

                    System.out.print("\n");

                    break;
                }
                case 3 -> {
                    for (int k = 0; k < array.length; k++) {
                        System.out.print(names[k] + " ");
                    }

                    System.out.print("\n");

                    break;
                }
                case 4 -> {
                    System.out.println("Exiting!!!");
                    break;
                }
                default -> {
                    System.out.println("Invalid selection!!!");
                }
            }
        }
    }
}


