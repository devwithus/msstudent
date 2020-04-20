package com.crud.msstudent.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.msstudent.models.Student;
import com.crud.msstudent.repositories.StudentRepository;

@Service
public class StudentService implements IStudent {
    
    StudentRepository studentrepo;
    @Autowired
    public StudentService(StudentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }
    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        return studentrepo.findAll();
    }
    @Override
    public Optional<Student> findById(int id) {
        // TODO Auto-generated method stub
        return studentrepo.findById(id);
    }
    @Override
    public Optional<Student> findByEmail(String email) {
        // TODO Auto-generated method stub
        return studentrepo.findByEmail(email);
    }
    @Override
    public Student save(Student std) {
        // TODO Auto-generated method stub
        return studentrepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        studentrepo.deleteById(id);
    }
}