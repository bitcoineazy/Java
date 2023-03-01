package com.example.studentdbspring;

import com.example.studentdbspring.Student;
import com.example.studentdbspring.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }
    
    // @PostMapping("/")
    // public String addStudent(Student student) {
    //     studentRepository.save(student);
    //     return "redirect:/";
    // }

    @PostMapping("/")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }
}