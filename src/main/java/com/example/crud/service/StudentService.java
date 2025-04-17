package com.example.crud.service;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> listAll() {
        return repo.findAll();
    }

    public Student get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student save(Student student) {
        return repo.save(student);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
} 