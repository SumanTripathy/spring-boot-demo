package com.demo.springproject.controller;

import com.demo.springproject.entity.Student;
import com.demo.springproject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/{studentId}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student = studentService.findStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> student = studentService.findAllStudent();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Student> saveStudent(
            @RequestBody Student student) {
        Student studentResponse = studentService.saveStudent(student);
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/show-page")
    public ModelAndView showPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/studentpage.html");
        return modelAndView;
    }

}
