package com.crud.msstudent.controllers;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.msstudent.exceptions.StudentNotFoundException;
import com.crud.msstudent.models.Student;
import com.crud.msstudent.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentService studentservice;
    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }
    @GetMapping(value="/students")
    public List<Student> getAllStudents(){
        return studentservice.getAllStudents();
    }           
    @GetMapping(value="/students/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) int id) {
        Student std = studentservice.findById(id)
                                    .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        return std;
    }           
    @PostMapping(value="/students")
    public Student addStudent(@Valid @RequestBody Student std) {
        return studentservice.save(std);
    }           
    @PutMapping(value="/students/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Student newstd) {
        Student stdu = studentservice.findById(id)
                                     .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        stdu.setFirstname(newstd.getFirstname());
        stdu.setLastname(newstd.getLastname());
        stdu.setEmail(newstd.getEmail());
        return studentservice.save(stdu); 
    }           
    @DeleteMapping(value="/students/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) int id) {
        Student std = studentservice.findById(id)
                                     .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        studentservice.deleteById(std.getId());
        return "Student with ID :"+id+" is deleted";            
    }
}
