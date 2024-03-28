package org.example.ServiceLayer;

import lombok.extern.slf4j.Slf4j;
import org.example.Dtos.StudentEnrollsSubjectDto;
import org.example.Dtos.StudentRegisteredExamDto;
import org.example.EntityLayer.*;
import org.example.ExceptionLayer.ExamAlreadyRegistedException;
import org.example.ExceptionLayer.StudentNotEnrolledTheSubjectException;
import org.example.ExceptionLayer.SubjectAlreadyEnrolledException;
import org.example.RepositoryLayer.ExamRepository;
import org.example.RepositoryLayer.StudentRepository;
import org.example.RepositoryLayer.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class StudentEnrollingService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ExamService examService;

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;

    public StudentEnrollsSubjectDto enrollSubject(int studentId, int subjectId){

        // Subject Validation
        Subject subject=subjectService.getSubjectById(subjectId);
        log.info("Subject info by enrollSubject function = {}",subject);

        // Student Validation
        Student student=studentService.getStudentById(studentId);
        log.info("Student info by enrollSubject function = {}", student);

        //   Is student previously Enrolled the Subject ?
        Optional<StudentEnrollSubject> subjectEnrollOptional= student.getEnrolledSubjects().stream()
                .filter(s->s.getSubjectId()==subjectId).findAny();
        if(!subjectEnrollOptional.isEmpty()){
            throw new SubjectAlreadyEnrolledException("Subject Already Enrolled by Student");
        }

        // Enroll the Subject
        student.getEnrolledSubjects().add(new StudentEnrollSubject(studentId,subjectId));
        log.info("Subject info by enrollSubject function after Update ---------- = {}",subject);


        studentRepository.save(student);
        subjectRepository.save(subject);

        return new StudentEnrollsSubjectDto(student,subject);
    }

    public StudentRegisteredExamDto examRegisteration(int studentId, int examId){
        //Student Validation
        Student student=studentService.getStudentById(studentId);

        //Exam Validation
        Exam exam=examService.getExamById(examId);

        int subjectId=exam.getSubjectId();

        // Is student previously Enrolled the Subject ?
        student.getEnrolledSubjects().stream()
                .filter(a->a.getSubjectId()==subjectId)
                .findAny().orElseThrow(()
                        ->new StudentNotEnrolledTheSubjectException(" Student with the given Id is Not Enrolled the Subject"));


        // Is student previously registed for Exam ?
       Optional<StudentExamRegistered> exam1= student.getRegisteredExams().stream().filter(a->a.getExamId()==examId)
                .findAny();
       if(!exam1.isEmpty()){
         throw  new ExamAlreadyRegistedException("Exam Already Registered ");
       }

       // Register the Student for Exam
          student.getRegisteredExams().add(new StudentExamRegistered(studentId,examId,subjectId));
          studentRepository.save(student);
          examRepository.save(exam);

          return new StudentRegisteredExamDto(student,exam);
    }

}
