package com.crud.msstudent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.msstudent.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
