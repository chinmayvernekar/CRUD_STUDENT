package com.chinmay.crud.service;

import com.chinmay.crud.model.Student;
import com.chinmay.crud.repo.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class SudentServiceImpl implements StudentService {


    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SudentServiceImpl.class));

    @Autowired
    StudentRepo studentRepo;

    public Student save(Student student) {
        return studentRepo.saveAndFlush(student);
    }


    @Override
    public ResponseEntity<?> getAllStudent() {

        List<Student> students = null;
        try {
            students = studentRepo.findAll();
        } catch (Exception e) {
            LOGGER.warning("saveStudent(): " + e.getMessage());
        }
        return ResponseEntity.ok(students);
    }

    @Override
    public ResponseEntity<?> findStudentByStudentId(UUID studentId) {
        Student student = null;
        try {
            student = studentRepo.findById(studentId).orElseThrow();

        } catch (Exception e) {
            LOGGER.warning("saveStudent(): " + e.getMessage());
        }
        return ResponseEntity.ok(student);
    }

    @Override
    public ResponseEntity<?> saveStudent(Student student) {
        try {
            studentRepo.save(student);
            LOGGER.info("Student Registration Successful.");
        } catch (Exception e) {
            LOGGER.warning("saveStudent(): " + e.getMessage());
        }
        return ResponseEntity.ok(student);
    }

    @Override
    public ResponseEntity<?> deleteStudent(UUID studentId) {
        Map<String, String> map = new HashMap<>();

        try {
            studentRepo.deleteById(studentId);
            map.put("message", "Deleted.");
            LOGGER.info("Student Deleted Successful.");
        } catch (Exception e) {
            LOGGER.warning("deleteStudent(): " + e.getMessage());
        }
        return ResponseEntity.ok(map);
    }

    @Override
    public ResponseEntity<?> updateStudent(UUID studentId, Student student) {
        Map<String, String> map = new HashMap<>();
        try {
            Optional<Student> student1 = studentRepo.findById(studentId);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String studentJson = ow.writeValueAsString(student);
            JSONObject studentResponse = new JSONObject(studentJson.toString());
            if (student1.isPresent()) {
                Student student2 = student1.get();
                if (studentResponse.has("firstName") && !studentResponse.isNull("firstName")) {
                    student2.setFirstName(studentResponse.getString("firstName"));
                }

                if (studentResponse.has("lastName") && !studentResponse.isNull("lastName")) {
                    student2.setLastName(studentResponse.getString("lastName"));
                }

                if (studentResponse.has("divison") && !studentResponse.isNull("divison")) {
                    student2.setDivison(studentResponse.getString("divison"));
                }

                if (studentResponse.has("address") && !studentResponse.isNull("divison")) {
                    student2.setAddress(studentResponse.getString("divison"));
                }

                if (studentResponse.has("rollNo") && !studentResponse.has("rollNo")) {
                    student2.setRollNo(Integer.parseInt(studentResponse.getString("rollNo")));
                }

                if (studentResponse.has("standrad") && !studentResponse.has("standrad")) {
                    student2.setStandrad(Integer.parseInt(studentResponse.getString("standrad")));
                }
                map.put("message", "Student Updated Successful.");
                LOGGER.info("Student Updated Successful.");
                return new ResponseEntity<>(studentRepo.save(student2), HttpStatus.OK);
            } else {
                LOGGER.warning("updateStudent(): " + HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }

        } catch (Exception e) {
            LOGGER.warning("updateStudent(): " + e.getMessage());
        }
        return ResponseEntity.ok(student);
    }


}
