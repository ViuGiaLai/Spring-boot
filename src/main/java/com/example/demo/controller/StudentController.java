package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }
    
    // tìm kiếm sinh viên theo tên
    @GetMapping("/students/search")
    public String searchStudents(@RequestParam("name") String name, Model model) {
        List<Student> students = studentService.searchStudentsByName(name);
        model.addAttribute("students", students);
        model.addAttribute("searchTerm", name);
        return "students";
    }
    
    // chi tiết sinh viên
    @GetMapping("/students/{id}")
    public String viewStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-detail";
    }
}
