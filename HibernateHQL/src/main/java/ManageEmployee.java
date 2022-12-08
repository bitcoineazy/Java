import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import java.util.List;

public class ManageEmployee {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {

        // Create Configuration
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate/xml/hibernate.cfg.xml");
//
//        // Create Session Factory
//        sessionFactory = configuration.buildSessionFactory();
//
//        // Initialize Session Object
//        Session session = sessionFactory.openSession();
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
//        session.close();
//
//        ManageEmployee manageEmployee = new ManageEmployee();
//
//        manageEmployee.getAllEmployees();
//        manageEmployee.getAllDepartments();
//
//        System.out.println("Get employee by ID");
//        manageEmployee.getEmployeeById(1);
//        manageEmployee.getEmployeeByName("John");
//        manageEmployee.getEmployeeByBirthDate("2000-01-01");
    }

    public void getAllEmployees() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Employee> employees = session.createQuery("FROM Employee").list();
            for (Employee employee : employees) {
                System.out.printf("Employee:");
                System.out.println("\tID: " + employee.getId());
                System.out.print("\tFirst Name: " + employee.getFirstName());
                System.out.print("\tLast Name: " + employee.getSurname());
                System.out.println("\tBirth Date:" + employee.getBirthDate());
                System.out.println("\tBirth Place:" + employee.getBirthPlace());
                System.out.println("\tSalary:" + employee.getSalary());

                Department department = employee.getDepartment();
                System.out.println("\tDepartment: ");
                System.out.println("\t\tID: " + department.getId());
                System.out.println("\t\tTitle: " + department.getTitle());
                System.out.println("\t\tDescription: " + department.getDescription());
                System.out.println("\t\tDirector: " + department.getDirector());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getAllDepartments() {

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            List<Department> departments = session.createQuery("FROM Department").list();
            for (Department department : departments) {
                System.out.println("Department:");
                System.out.print("\tID: " + department.getId());
                System.out.print("\tTitle: " + department.getTitle());
                System.out.print("\tDescription: " + department.getDescription());
                Employee director = department.getDirector();
                System.out.println("\tDirector: ");
                System.out.println("\t\tID: " + director.getId());
                System.out.println("\t\tFirstname: " + director.getFirstName());
                System.out.println("\t\tSurname: " + director.getSurname());
                System.out.println("\t\tSalary: " + director.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Integer addEmployee(String firstname, String surname, String birthDate, String birthPlace, int salary, Department department){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(firstname, surname, birthDate, birthPlace, salary, department);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    public void getEmployeeById(Session session, int employeeId) {
        Transaction tx = null;
        Employee employee = null;
        try (session) {
            tx = session.beginTransaction();
            employee = (Employee) session.get(Employee.class, employeeId);
            System.out.println(employee.toString());
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void getEmployeeByName(String firstname) {
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            List<Employee> employees = session.createQuery(String.format("FROM Employee WHERE firstName='%s'", firstname)).list();
            for (Employee each_employee: employees) {
                System.out.println(each_employee.toString());
            }

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getEmployeeByBirthDate(String birthDate) {
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            List<Employee> employees = session.createQuery(String.format("FROM Employee WHERE birthDate='%s'", birthDate)).list();
            for (Employee each_employee: employees) {
                System.out.println(each_employee.toString());
            }

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}