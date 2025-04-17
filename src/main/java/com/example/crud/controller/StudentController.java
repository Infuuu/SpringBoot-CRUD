package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student existing = service.get(id);
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setEmail(updatedStudent.getEmail());
            existing.setDepartment(updatedStudent.getDepartment());
            existing.setRollNumber(updatedStudent.getRollNumber());
            return service.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.delete(id);
    }
} 