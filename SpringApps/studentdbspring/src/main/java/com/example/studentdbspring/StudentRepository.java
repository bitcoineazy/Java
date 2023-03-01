package com.example.studentdbspring;



import com.example.studentdbspring.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}