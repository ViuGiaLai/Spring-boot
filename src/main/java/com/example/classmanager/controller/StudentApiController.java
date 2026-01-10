package com.example.classmanager.controller;

import com.example.classmanager.entity.Student;
import com.example.classmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentService studentService;

    // READ ALL
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // CREATE
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student update(
            @PathVariable Long id,
            @RequestBody Student student
    ) {
        student.setId(id); 
        return studentService.saveStudent(student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    // SEARCH
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentService.searchStudentsByName(name);
    }
}
