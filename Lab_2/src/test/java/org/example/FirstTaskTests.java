package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTaskTests {

    Employee firstEmployee = new Employee("Shrek", "Shrek", 123, 1000,
            "Uganda", 1000, "Married");

    @Test
    @DisplayName("Testing")
    void testEmployeeInformation() {
        assertTrue(Objects.equals(firstEmployee.name, "Shrek"));
        assertTrue(Objects.equals(firstEmployee.surname, "Shrek"));
        assertTrue(Objects.equals(firstEmployee.employeeId, 123));
        assertTrue(Objects.equals(firstEmployee.birthYear, 1000));
        assertTrue(Objects.equals(firstEmployee.birthPlace, "Uganda"));
        assertTrue(Objects.equals(firstEmployee.salary, 1000));
        assertTrue(Objects.equals(firstEmployee.familyStatus, "Married"));
    }

}
