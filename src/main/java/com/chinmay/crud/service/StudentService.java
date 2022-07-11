package com.chinmay.crud.service;

import com.chinmay.crud.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface StudentService {

    ResponseEntity<?> getAllStudent();


    ResponseEntity<?> findStudentByStudentId(UUID studentId);

    ResponseEntity<?> saveStudent(Student student);

    ResponseEntity<?> deleteStudent(UUID studentId);

    ResponseEntity<?> updateStudent(UUID studentId,Student student);
}
