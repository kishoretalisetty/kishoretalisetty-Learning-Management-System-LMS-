package org.example.GlobalExceptionHandlerLayer;

import org.example.ExceptionLayer.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException e) {
        return new ResponseEntity<>(" Exception : " + e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ExamNotFoundException.class)
    public ResponseEntity<String> handleExamNotFoundException(ExamNotFoundException e) {
        return new ResponseEntity<>(" Exception : " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<String> handleSubjectNotFoundException(SubjectNotFoundException e) {
        return new ResponseEntity<>(" Exception : " + e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ExamAlreadyRegistedException.class)
    public ResponseEntity<String> handleExamAlreadyRegistedException(ExamAlreadyRegistedException e) {
        return new ResponseEntity<>(" Exception : " + e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(SubjectAlreadyEnrolledException.class)
    public ResponseEntity<String> handleSubjectAlreadyEnrolledException(SubjectAlreadyEnrolledException e) {
        return new ResponseEntity<>(" Exception : " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentNotEnrolledTheSubjectException.class)
    public ResponseEntity<String> handleStudentNotEnrolledTheSubject(StudentNotEnrolledTheSubjectException e) {
        return new ResponseEntity<>(" Exception : " + e.getMessage(), HttpStatus.NOT_FOUND);
    }


}
