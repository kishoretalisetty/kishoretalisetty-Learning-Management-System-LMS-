package org.example.ControllerLayer;

import org.example.EntityLayer.Student;
import org.example.ServiceLayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestParam(name = "name") String name){
        Student student= studentService.addStudent(name);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(@RequestParam(name = "studentId") Integer studentId){
        Student student=studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/student")
    public  void deleteStudent(@RequestParam(name = "studentId") Integer studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/" +
            "")
    public ResponseEntity<List<Student>>  getAllStudents(){
       return ResponseEntity.ok(studentService.findAllStudents());
    }
}
