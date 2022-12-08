import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    static final String DATABASE_URL = "jdbc:sqlite:mydb.db";
    private static SessionFactory sessionFactory;

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
        Menu menu = new Menu();
        Menu changeMenu = new Menu();

        Configuration configuration = new Configuration();
        configuration.configure("hibernate/xml/hibernate.cfg.xml");
//
        // Create Session Factory
        sessionFactory = configuration.buildSessionFactory();

        // Initialize Session Object
        Session session = sessionFactory.openSession();
//
//        // Get all entries using Criteria API
//        System.out.println("Getting all people using the Criteria API");
//        List<Employee> entriesCriteria=CommonMethods.getAllEntriesUsingCriteriaApi(session, Employee.class);
//        for(Employee entry:entriesCriteria)
//        {
//            System.out.println(entry);
//        }
//
//        // Get all entries using HQL
//        System.out.println("Getting all people using JPQL");
//        List<Employee> entriesHQL= CommonMethods.getAllEntriesUsingHQL(session, Employee.class);
//        for(Employee entry:entriesHQL)
//        {
//            System.out.println(entry);
//        }
//
//        System.out.println("Get all departments using JPQL");
//        List<Department> entriesDepartmentHQL= CommonMethods.getAllDepartmentsUsingHQL(session, Department.class);
//        for(Department entry:entriesDepartmentHQL)
//        {
//            System.out.println(entry);
//        }
//        //session.close();

        ManageEmployee manageEmployee = new ManageEmployee();

//        manageEmployee.getAllEmployees();
//        manageEmployee.getAllDepartments();
//
//        System.out.println("Get employee by ID");
//        manageEmployee.getEmployeeById(1);
//        manageEmployee.getEmployeeByName("John");
//        manageEmployee.getEmployeeByBirthDate("2000-01-01");

        try {

            changeMenu.addItem(1, "id", (stems, in) -> {
//                System.out.print("id employer: ");
//                Integer id = in.nextInt();
//                System.out.print("new id: ");
//                Integer new_id = in.nextInt();
//                try {
//                    stems.executeUpdate(String.format("UPDATE people SET id = %s where id = %s", new_id, id));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            changeMenu.addItem(2, "name", (stems, in) -> {
//                System.out.print("id employer: ");
//                String id = in.next();
//                System.out.print("new firstname: ");
//                String new_name = in.next();
//                try {
//                    stems.executeUpdate(String.format("UPDATE people SET firstname = '%s' where id = %s", new_name, id));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            changeMenu.addItem(3, "surname", (stems, in) -> {
//                System.out.print("id employer: ");
//                String id = in.next();
//                System.out.print("new surname: ");
//                String new_surname = in.next();
//                try {
//                    stems.executeUpdate(String.format("UPDATE people SET surname = '%s' where id = %s", new_surname, id));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            changeMenu.addItem(4, "date_of_birth", (stems, in) -> {
//                System.out.print("id employer: ");
//                String id = in.next();
//                System.out.print("new date_of_birth: ");
//                String new_date_of_birth = in.next();
//                try {
//                    stems.executeUpdate(String.format("UPDATE people SET date_of_birth = '%s' where id = %s", new_date_of_birth, id));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            changeMenu.addItem(5, "place_of_birth", (stems, in) -> {
//                System.out.print("id employer: ");
//                String id = in.next();
//                System.out.print("new place_of_birth: ");
//                String new_place_of_birth = in.next();
//                try {
//                    stems.executeUpdate(String.format("UPDATE people SET place_of_birth = '%s' where id = %s", new_place_of_birth, id));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            changeMenu.addItem(6, "salary", (stems, in) -> {
//                System.out.print("id employer: ");
//                String id = in.next();
//                System.out.print("new salary: ");
//                String new_salary = in.next();
//                try {
//                    stems.executeUpdate(String.format("UPDATE people SET salary = %s where id = %s", new_salary, id));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            changeMenu.addItem(7, "family_status", (stems, in) -> {
//                System.out.print("id employer: ");
//                String id = in.next();
//                System.out.print("new family_status: ");
//                String new_family_status = in.next();
//                try {
//                    stems.executeUpdate(String.format("UPDATE people SET family_status = %s where id = %s", new_family_status, id));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            menu.addItem(1, "Добавить сотрудника", (stems, in) -> {
//                try {
////                    System.out.print("id: ");
////                    int id = in.nextInt();
//                    System.out.print("firstname: ");
//                    String firstname = in.next();
//                    System.out.print("surname: ");
//                    String surname = in.next();
//                    System.out.print("date_of_birth: ");
//                    String date_of_birth = in.next();
//                    System.out.print("place_of_birth: ");
//                    String place_of_birth = in.next();
//                    System.out.print("salary: ");
//                    String salary = in.next();
//                    System.out.print("family_status: ");
//                    String family_status = in.next();
//                    stems.executeUpdate(String.format("INSERT INTO people(" +
//                                    "firstname, surname, date_of_birth, place_of_birth, salary, family_status) " +
//                                    "VALUES ('%s','%s','%s','%s',%s,%s)", firstname, surname, date_of_birth, place_of_birth,
//                            salary, family_status)
//                    );
//                    System.out.println("Сотрудник успешно добавлен в базу!");
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            menu.addItem(2, "Получить сотрудника по ID", (stems, in) -> {
                manageEmployee.getEmployeeById(session, in.nextInt());
            });
            menu.addItem(3, "Получить сотрудника по имени", (stems, in) -> {
                System.out.print("Write name: ");
                String name = in.next();
//                    Task8.printouts(stems.executeQuery("SELECT * FROM people WHERE firstname = '" + name + "'"));
            });
            menu.addItem(4, "Получить сотрудника по дате рождения", (stems, in) -> {
                System.out.print("Write date of birth: ");
                String date_of_birth = in.next();
//                    Task8.printouts(stems.executeQuery("SELECT * FROM people WHERE date_of_birth = '" + date_of_birth + "'"));
            });
            menu.addItem(5, "Изменить информацию о сотруднике", (stems, in) -> {
                changeMenu.printMenu();
                System.out.print(": ");
                int selectedOption = in.nextInt();
                changeMenu.run(selectedOption, null, in);
            });
            menu.addItem(6, "Удалить сотрудника", (stems, in) -> {
//                try {
//                    System.out.print("ID сотрудника: ");
//                    String id = in.next();
//                    stems.executeUpdate(String.format("DELETE FROM people WHERE id = %s", id));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            menu.addItem(7, "Получить общую зарплату", (stems, in) -> {
//                try {
//                    ResultSet res = stems.executeQuery("SELECT SUM(people.salary) FROM people");
//                    res.next();
//                    System.out.println(String.format("Общая зарплата: %s", res.getString(1)));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            menu.addItem(8, "Получить сотрудников по департаменту", (stems, in) -> {
//                try {
//                    ResultSet res = stems.executeQuery("SELECT SUM(people.salary) FROM people");
//                    res.next();
//                    System.out.println(String.format("Общая зарплата: %s", res.getString(1)));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            menu.addItem(9, "Вывести все информации о департаменте", (stems, in) -> {
//                try {
//                    ResultSet res = stems.executeQuery("SELECT SUM(people.salary) FROM people");
//                    res.next();
//                    System.out.println(String.format("Общая зарплата: %s", res.getString(1)));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            menu.addItem(10, "Изменить любую информацию о департаменте.", (stems, in) -> {
//                try {
//                    ResultSet res = stems.executeQuery("SELECT SUM(people.salary) FROM people");
//                    res.next();
//                    System.out.println(String.format("Общая зарплата: %s", res.getString(1)));
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            });
            Scanner in = new Scanner(System.in);
            do {
                menu.printMenu();
                //System.out.print("");
                int selectedOption = in.nextInt();
                menu.run(selectedOption, sessionFactory, in);
            } while (true);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}