package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy sinh viên với ID: " + id)
                );
    }

    // tìm kiếm theo tên (để khớp với controller)
    public List<Student> searchStudentsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
