package com.anish.sample.controller;

import com.anish.sample.entity.Student;
import com.anish.sample.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController
{
    private StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return "Student added successfully";
    }
}
