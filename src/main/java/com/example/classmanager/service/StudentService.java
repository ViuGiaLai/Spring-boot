package com.example.classmanager.service;

import com.example.classmanager.entity.Student;
import com.example.classmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // READ 
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy sinh viên với ID: " + id)
                );
    }

    //  SEARCH 
    public List<Student> searchStudentsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    // CREATE & UPDATE 
    // Dùng CHUNG cho thêm & sửa
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // DELETE 
    public void deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Không thể xóa. Không tìm thấy sinh viên với ID: " + id);
        }
        repository.deleteById(id);
    }
}
