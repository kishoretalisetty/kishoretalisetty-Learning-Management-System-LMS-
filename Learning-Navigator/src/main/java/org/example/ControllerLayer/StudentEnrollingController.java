package org.example.ControllerLayer;

import org.example.Dtos.StudentEnrollsSubjectDto;
import org.example.Dtos.StudentRegisteredExamDto;
import org.example.ServiceLayer.StudentEnrollingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentEnrollingController {

    @Autowired
    private StudentEnrollingService studentEnrollingService;

    @PutMapping("/enroll")
    public ResponseEntity<StudentEnrollsSubjectDto> enroll(@RequestParam(name="studentId") Integer studentId,
                                    @RequestParam(name="subjectId") Integer subId){
        StudentEnrollsSubjectDto studentEnrollsSubjectDto
                = studentEnrollingService.enrollSubject(studentId, subId);

        return ResponseEntity.ok(studentEnrollsSubjectDto);
    }

    @PutMapping("/register/exam")
    public ResponseEntity<StudentRegisteredExamDto> examRegistration(@RequestParam(name = "studentId") int studentId,
                                              @RequestParam(name = "examId") int examId){

       StudentRegisteredExamDto studentRegisteredExamDto=
               studentEnrollingService.examRegisteration(studentId, examId);

       return ResponseEntity.ok(studentRegisteredExamDto);
    }
}
