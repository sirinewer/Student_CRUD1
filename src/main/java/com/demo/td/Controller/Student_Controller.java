package com.demo.td.Controller;

import com.demo.td.Entity.Student;
import com.demo.td.Repository.Student_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/student")
public class Student_Controller {
    @Autowired
    private Student_Repository student_Repository;

    //Create (POST) :
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = student_Repository.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //Read (GET):
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = student_Repository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Optional<Student> student = student_Repository.findById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //Update (PUT):
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = student_Repository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setNom(studentDetails.getNom());
            student.setPrenom(studentDetails.getPrenom());

            Student updatedStudent = student_Repository.save(student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Delete (DELETE):
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        student_Repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
