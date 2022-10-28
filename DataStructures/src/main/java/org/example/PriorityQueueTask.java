package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Client {

    private String name;
    private double distance;

    public Client(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }
    public double getDistance() {
        return this.distance;
    }
    public String getName() {
        return this.name;
    }
}

class ServeClientComparator implements Comparator<Client> {
    /*
    Упорядочить обслуживание клиентов
    Приоритет у тех, кто дальше находиться
     */
    public int compare(Client firstClient, Client secondClient) {
        if (firstClient.getDistance() < secondClient.getDistance()) {
            return 1;
        } else if (firstClient.getDistance() > secondClient.getDistance()) {
            return -1;
        }
        return 0;
    }
}

public class PriorityQueueTask {
    /*
    Используйте класс PriorityQueue и интерфейс Comparator для создания программы, организующей
    очередь клиентов в компании. Программа упорядочивает клиентов в порядке их прибытия, но
    клиенты, прибывающие из дальних городов, имеют более высокий приоритет, чем местные жители
    или близлежащие города. Ваша программа должна позволять оператору вводить информацию о
    клиентах и вызвать клиентов в правильном порядке для их обслуживания.
     */
    public static int menuOption;
    public static void main(String[] args) {
        PriorityQueue<Client> clientPriorityQueue = new PriorityQueue<Client>(10, new ServeClientComparator());

        Client firstClient = new Client("Matvey", 100);
        clientPriorityQueue.add(firstClient);
        Client secondClient = new Client("Paul", 100);
        clientPriorityQueue.add(secondClient);
        Client thirdClient = new Client("Daniel",200);
        clientPriorityQueue.add(thirdClient);

        Scanner in = new Scanner(System.in);
        while (menuOption != 4) {
            System.out.println("""
                    
                    1 - Список всех клиентов
                    2 - Произвести обслуживание клиента
                    3 - Добавить клиента
                    
                    """);
            menuOption = in.nextInt();
            switch (menuOption) {
                case (1) -> {
                    for (Client client: clientPriorityQueue) {
                        System.out.println("Имя: " + client.getName() + ", Расстояние: " + client.getDistance());
                    }
                }
                case (2) -> {
                    System.out.println();
                    Client headClient = clientPriorityQueue.poll();
                    System.out.println("Обслужен клиент: " + headClient.getName() + ", Расстояние до него: " + headClient.getDistance());
                }
                case (3) -> {
                    System.out.print("Введите имя клиента: ");
                    String name = in.next();
                    System.out.print("Введите расстояние до клиента: ");
                    double dist = in.nextDouble();
                    try {
                        clientPriorityQueue.add(new Client(name, dist));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                }
            }
        }

    }
}
