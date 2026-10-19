package com.anish.sample.service;

import com.anish.sample.entity.Student;
import com.anish.sample.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }
    public void addStudent( Student student)
    {
         studentRepository.save(student);
    }
}
