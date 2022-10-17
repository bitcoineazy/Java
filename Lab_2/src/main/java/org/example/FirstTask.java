package org.example;

import java.util.Objects;
import java.util.Scanner;

class Employee {
    String name;


    int employeeId;

    String surname;

    int birthYear;

    String birthPlace;

    int salary;

    String familyStatus;

    public Employee(String name, String surname, int employeeId, int birthYear, String birthPlace, int salary, String familyStatus) {
        //employeeCounter ++;
        this.setName(name);
        this.setEmployeeId(employeeId);
        this.employeeId = employeeId;
        this.birthYear = birthYear;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.familyStatus = familyStatus;
        this.birthPlace = birthPlace;
        //this.setSurname(surname);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public boolean printAllInformation() {

        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.println("ID: " + this.employeeId);
        System.out.println("Birth Year: " + this.birthYear);
        System.out.println("Birth Place: " + this.birthPlace);
        System.out.println("Salary: " + this.salary);
        System.out.println("Family status: " + this.familyStatus);

        return false;
    }


}

public class FirstTask {
    public static void main(String[] args) {
        System.out.println("""
                1 - Create new Employee
                2 - Get all Employee info by ID
                3 - Get Employee by Name or Birth Year
                4 - Change Employee Info
                5 - Print all Salary
                """);
        int selectedOption = -1;
        Employee[] employeeArray = new Employee[100];


        employeeArray[0] = new Employee("Shrek", "Shrek", 123
                , 1000, "Uganda", 1000, "Married");

        System.out.println(employeeArray[0].printAllInformation());

        int employeeCounter = 0;

        employeeCounter += 1;
        while (selectedOption != 6) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please input function number: ");
            selectedOption = in.nextInt();
            switch (selectedOption) {
                case (1) -> {
                    System.out.println("Please input employee name: ");
                    Scanner in_2 = new Scanner(System.in);
                    String new_name = in_2.nextLine();
                    System.out.println("Please input employee surname: ");
                    String new_surname = in_2.nextLine();
                    System.out.println("Please input employee id: ");
                    int new_id = in_2.nextInt();
                    System.out.println("Please input employee birth year: ");
                    int new_birthyear = in_2.nextInt();
                    System.out.println("Please input employee birth place: ");
                    Scanner new_birtplace_scanner = new Scanner(System.in);
                    String new_birthplace = new_birtplace_scanner.nextLine();
                    System.out.println("Please input employee salary: ");
                    int new_salary = in_2.nextInt();
                    System.out.println("Please input employee family status: ");
                    Scanner new_familystatus_scanner = new Scanner(System.in);
                    String new_familystatus = new_familystatus_scanner.nextLine();
                    //Employee new_person = new Employee(new_name);

                    for (int i = 0; i < employeeCounter; i++) {
                        if (employeeArray[i].employeeId == new_id) {
                            System.out.println("This Employee ID already exists!");
                            break;
                        }
                    }
                    employeeArray[employeeCounter] = new Employee(new_name, new_surname, new_id, new_birthyear,
                            new_birthplace, new_salary, new_familystatus);

                    System.out.println(employeeArray[employeeCounter].printAllInformation());

                    employeeCounter += 1;
                    break;
                }
                case (2) -> {
                    System.out.println("Please input employee id to find: ");
                    Scanner in_3 = new Scanner(System.in);
                    int findById = in_3.nextInt();
                    System.out.println(employeeArray.length);
                    for (int i=0; i < employeeCounter; i++)
                        if (employeeArray[i].employeeId == findById) employeeArray[i].printAllInformation();
                    break;
                }
                case (3) -> {


                    System.out.println("Please input employee Name or  Birth Year to find: ");
                    Scanner in_4 = new Scanner(System.in);
                    String input = in_4.nextLine();

                    int employeeBirthDate = 0;
                    String employeeName = "";

                    try {
                        employeeBirthDate = Integer.parseInt(input);
                    } catch(NumberFormatException | NullPointerException e) {
                        employeeName = input;
                    }

                    for (int i = 0; i < employeeCounter; i++) {
                        if (employeeArray[i].birthYear == employeeBirthDate | Objects.equals(employeeArray[i].name, employeeName)) {
                            employeeArray[i].printAllInformation();
                        }
                    }
                    break;
                }
                case (4) -> {
                    System.out.println("Please input Employee ID to change information: ");
                    Scanner in_5 = new Scanner(System.in);
                    int input_id = in_5.nextInt();
                    System.out.println(
                            """
                                Which info do you want to change?
                                1 - Name
                                2 - Surname
                                3 - Birth Year
                                4 - BirthPlace
                                5 - Salary
                                6 - Family Status
                            """);
                    int input_option = in_5.nextInt();
                    switch (input_option) {
                        case (1) -> {
                            System.out.println("Please input employee new Name: ");
                            Scanner name_scanner = new Scanner(System.in);
                            String new_name = name_scanner.nextLine();
                            for (int i = 0; i < employeeCounter; i++) {
                                if (employeeArray[i].employeeId == input_id) {
                                    employeeArray[i].name = new_name;
                                    System.out.println("Name successfully changed");
                                }
                            }
                        }
                        case (2) -> {
                            Scanner surname_scanner = new Scanner(System.in);
                            String new_surname = surname_scanner.nextLine();
                            for (int i = 0; i < employeeCounter; i++) {
                                if (employeeArray[i].employeeId == input_id) {
                                    employeeArray[i].surname = new_surname;
                                    System.out.println("Surname successfully changed");
                                }
                            }
                        }
                        case (3) -> {
                            Scanner year_scanner = new Scanner(System.in);
                            int new_birthyear = year_scanner.nextInt();
                            for (int i = 0; i < employeeCounter; i++) {
                                if (employeeArray[i].employeeId == input_id) {
                                    employeeArray[i].birthYear = new_birthyear;
                                    System.out.println("Birth year successfully changed");
                                }
                            }
                        }
                        case (4) -> {
                            Scanner birthplace_scanner = new Scanner(System.in);
                            String new_birthplace = birthplace_scanner.nextLine();
                            for (int i = 0; i < employeeCounter; i++) {
                                if (employeeArray[i].employeeId == input_id) {
                                    employeeArray[i].birthPlace = new_birthplace;
                                    System.out.println("Birth place successfully changed");
                                }
                            }
                        }
                        case (5) -> {
                            Scanner salary_scanner = new Scanner(System.in);
                            int new_salary = salary_scanner.nextInt();
                            for (int i = 0; i < employeeCounter; i++) {
                                if (employeeArray[i].employeeId == input_id) {
                                    employeeArray[i].salary = new_salary;
                                    System.out.println("Salary successfully changed");
                                }
                            }
                        }
                        case (6) -> {
                            Scanner family_scanner = new Scanner(System.in);
                            String new_familystatus = family_scanner.nextLine();
                            for (int i = 0; i < employeeCounter; i++) {
                                if (employeeArray[i].employeeId == input_id) {
                                    employeeArray[i].familyStatus = new_familystatus;
                                    System.out.println("Family status successfully changed");
                                }
                            }
                        }
                    }
                }
                case (5) -> {
                    double all_salary = 0;
                    for (int i = 0; i < employeeCounter; i++) {
                        all_salary += employeeArray[i].salary;
                    }
                    System.out.println("All salary = " + all_salary);
                }
            }
        }

        //System.out.println("Name: " + name);



    }
}
