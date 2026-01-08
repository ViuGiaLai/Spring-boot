package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Bài 1: Hello API
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }

    // Bài 2: API nhận tham số (Request Param)
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Xin chào " + name;
    }

    @GetMapping("/students/search")
    public String search(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int page) {
        return "keyword=" + keyword + ", page=" + page;
    }

    // Bài 3: API với Path Variable
    @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable int id) {
        return "Sinh viên có mã: " + id;
    }

    // Bài 4: Trả về JSON Object
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Nguyễn Văn A", 20);
    }

    // Bài 5: Trả về danh sách (List)
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Nguyễn Văn A", 20));
        list.add(new Student(2, "Trần Thị B", 21));
        return list;
    }
}
