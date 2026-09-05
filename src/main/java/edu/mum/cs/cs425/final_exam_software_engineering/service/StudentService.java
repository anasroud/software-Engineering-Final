package edu.mum.cs.cs425.final_exam_software_engineering.service;

import edu.mum.cs.cs425.final_exam_software_engineering.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student student);

    void deleteById(Long id);
}