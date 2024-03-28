package org.example.ControllerLayer;

import org.example.EntityLayer.Exam;
import org.example.ServiceLayer.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/exam")
    public ResponseEntity<Exam> addExam(@RequestParam(name = "subjectId") Integer subjectId){
        Exam exam= examService.addExam(subjectId);
        return ResponseEntity.ok(exam);
    }

    @GetMapping("/exam")
    public ResponseEntity<Exam> getExam(@RequestParam(name="examId") Integer examId){
        Exam exam=examService.getExamById(examId);
        return ResponseEntity.ok(exam);
    }

    @DeleteMapping("/exam")
    public void deleteExam(@RequestParam(name="examId") Integer examId){
        examService.deleteExamById(examId);
    }

    @GetMapping("/getAllExams")
    public ResponseEntity<List<Exam>> getAllExams(){
       return ResponseEntity.ok(examService.getAllExams());
    }
}
