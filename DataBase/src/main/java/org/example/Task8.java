package org.example;

import java.sql.*;
import java.util.Scanner;

public class Task8 {
    static final String DATABASE_URL = "jdbc:sqlite:mydb.db";

    public static void printouts(ResultSet res) {
        while (true) {
            try {
                if (!res.next()) break;
                System.out.println("ID: " + res.getInt("id"));
                System.out.println("Имя: " + res.getString("firstname"));
                System.out.println("Фамилия: " + res.getString("surname"));
                System.out.println("Дата рождения: " + res.getString("date_of_birth"));
                System.out.println("Место рождения: " + res.getString("place_of_birth"));
                System.out.println("Зарплата: " + res.getString("salary"));
                System.out.println("Семейное положение: " + res.getString("family_status"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        Menu changeMenu = new Menu();


        try (
            /*
            DriverManager:Этот элемент управляет списком драйверов БД.
            Каждой запрос на соединение требует соответствующего драйвера.
            Первое совпадение даёт нам соединение.
            Connection: Этот интерфейс обеспечивает нас методами для работы с БД.
            Все взаимодействия с БД происходят исключительно через Connection.
            */
                Connection conn = DriverManager.getConnection(DATABASE_URL);
            /*
            Statement: Для подтверждения SQL-запросов мы используем объекты,
            созданные с использованием этого интерфейса.
            */
                Statement stmt = conn.createStatement();
            /*
            ResultSet: Экземпляры этого элемента содержат данные, которые были получены в
            результате выполнения SQL – запроса. Он работает как итератор и “пробегает”
            по полученным данным.
            */
                ResultSet rs = stmt.executeQuery("SELECT * FROM people;");


        ) {
            changeMenu.addItem(1, "id", (stems, in) -> {
                System.out.print("id employer: ");
                Integer id = in.nextInt();
                System.out.print("new id: ");
                Integer new_id = in.nextInt();
                try {
                    stems.executeUpdate(String.format("UPDATE people SET id = %s where id = %s", new_id, id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            changeMenu.addItem(2, "name", (stems, in) -> {
                System.out.print("id employer: ");
                String id = in.next();
                System.out.print("new firstname: ");
                String new_name = in.next();
                try {
                    stems.executeUpdate(String.format("UPDATE people SET firstname = '%s' where id = %s", new_name, id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            changeMenu.addItem(3, "surname", (stems, in) -> {
                System.out.print("id employer: ");
                String id = in.next();
                System.out.print("new surname: ");
                String new_surname = in.next();
                try {
                    stems.executeUpdate(String.format("UPDATE people SET surname = '%s' where id = %s", new_surname, id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            changeMenu.addItem(4, "date_of_birth", (stems, in) -> {
                System.out.print("id employer: ");
                String id = in.next();
                System.out.print("new date_of_birth: ");
                String new_date_of_birth = in.next();
                try {
                    stems.executeUpdate(String.format("UPDATE people SET date_of_birth = '%s' where id = %s", new_date_of_birth, id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            changeMenu.addItem(5, "place_of_birth", (stems, in) -> {
                System.out.print("id employer: ");
                String id = in.next();
                System.out.print("new place_of_birth: ");
                String new_place_of_birth = in.next();
                try {
                    stems.executeUpdate(String.format("UPDATE people SET place_of_birth = '%s' where id = %s", new_place_of_birth, id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            changeMenu.addItem(6, "salary", (stems, in) -> {
                System.out.print("id employer: ");
                String id = in.next();
                System.out.print("new salary: ");
                String new_salary = in.next();
                try {
                    stems.executeUpdate(String.format("UPDATE people SET salary = %s where id = %s", new_salary, id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            changeMenu.addItem(7, "family_status", (stems, in) -> {
                System.out.print("id employer: ");
                String id = in.next();
                System.out.print("new family_status: ");
                String new_family_status = in.next();
                try {
                    stems.executeUpdate(String.format("UPDATE people SET family_status = %s where id = %s", new_family_status, id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            mainMenu.addItem(1, "Добавить сотрудника", (stems, in) -> {
                try {
//                    System.out.print("id: ");
//                    int id = in.nextInt();
                    System.out.print("firstname: ");
                    String firstname = in.next();
                    System.out.print("surname: ");
                    String surname = in.next();
                    System.out.print("date_of_birth: ");
                    String date_of_birth = in.next();
                    System.out.print("place_of_birth: ");
                    String place_of_birth = in.next();
                    System.out.print("salary: ");
                    String salary = in.next();
                    System.out.print("family_status: ");
                    String family_status = in.next();
                    stems.executeUpdate(String.format("INSERT INTO people(" +
                                    "firstname, surname, date_of_birth, place_of_birth, salary, family_status) " +
                                    "VALUES ('%s','%s','%s','%s',%s,%s)", firstname, surname, date_of_birth, place_of_birth,
                            salary, family_status)
                    );
                    System.out.println("Сотрудник успешно добавлен в базу!");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            mainMenu.addItem(2, "Получить сотрудника по ID", (stems, in) -> {
                try {
                    System.out.print("Write id: ");
                    int id = in.nextInt();
                    Task8.printouts(stems.executeQuery("SELECT * FROM people WHERE id = " + id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            mainMenu.addItem(3, "Получить сотрудника по имени", (stems, in) -> {
                try {
                    System.out.print("Write name: ");
                    String name = in.next();
                    Task8.printouts(stems.executeQuery("SELECT * FROM people WHERE firstname = '" + name + "'"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            mainMenu.addItem(4, "Получить сотрудника по дате рождения", (stems, in) -> {
                try {
                    System.out.print("Write date of birth: ");
                    String date_of_birth = in.next();
                    Task8.printouts(stems.executeQuery("SELECT * FROM people WHERE date_of_birth = '" + date_of_birth + "'"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            mainMenu.addItem(5, "Изменить информацию о сотруднике", (stems, in) -> {
                changeMenu.printMenu();
                System.out.print(": ");
                int selectedOption = in.nextInt();
                changeMenu.run(selectedOption, stmt, in);
            });
            mainMenu.addItem(6, "Удалить сотрудника", (stems, in) -> {
                try {
                    System.out.print("ID сотрудника: ");
                    String id = in.next();
                    stems.executeUpdate(String.format("DELETE FROM people WHERE id = %s", id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            mainMenu.addItem(7, "Получить общую зарплату", (stems, in) -> {
                try {
                    ResultSet res = stems.executeQuery("SELECT SUM(people.salary) FROM people");
                    res.next();
                    System.out.println(String.format("Общая зарплата: %s", res.getString(1)));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            Scanner in = new Scanner(System.in);
            do {
                mainMenu.printMenu();
                //System.out.print("");
                int selectedOption = in.nextInt();
                mainMenu.run(selectedOption, stmt, in);
            } while (true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}