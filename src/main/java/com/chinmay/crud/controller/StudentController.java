package com.chinmay.crud.controller;

import com.chinmay.crud.model.Student;
import com.chinmay.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "studentId",required = true) UUID studentId){
        return studentService.deleteStudent(studentId);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestParam(name = "studentId",required = true) UUID studentId,@RequestBody Student student){
        return studentService.updateStudent(studentId,student);
    }

    @GetMapping()
    public ResponseEntity<?> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> findStudentByStudentId(@PathVariable(name = "studentId") UUID studentId){
        return studentService.findStudentByStudentId(studentId);
    }
}
