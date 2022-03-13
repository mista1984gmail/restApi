package com.mista1984.rest.service;

import com.mista1984.rest.controller.Student;
import com.mista1984.rest.repository.StudentRepository;
import com.mista1984.rest.response.RestApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list(){
       return studentRepository.findAll();
        }

    public void add(Student student){
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new RestApiException("Email is busy");
        }

        studentRepository.save(student);
        }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void update(Student student) {
        Optional<Student> row = studentRepository.findById(student.getId());
        if (row.isPresent()){
            Student item = row.get();
            if (!student.getName().isEmpty()){
                item.setName(student.getName());
            }
            if (student.getDob() != null){
                item.setDob(student.getDob());
            }

        studentRepository.save(item);
    }
    }

    
}
