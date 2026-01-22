package com.example.classmanager.repository;

import com.example.classmanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> findByNameContainingIgnoreCase(String name);
}
