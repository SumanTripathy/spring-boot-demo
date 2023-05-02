package com.demo.springproject.service;

import com.demo.springproject.entity.Student;
import com.demo.springproject.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId);
        if (student == null)
            throw new RuntimeException("STUDENT_NOT_FOUND FOR ID = " + studentId);
        return student;
    }

    public List<Student> findAllStudent() {
        List<Student> students = studentRepository.findAll();
        if (CollectionUtils.isEmpty(students))
            throw new RuntimeException("NO_STUDENT_FOUND");
        return students;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
