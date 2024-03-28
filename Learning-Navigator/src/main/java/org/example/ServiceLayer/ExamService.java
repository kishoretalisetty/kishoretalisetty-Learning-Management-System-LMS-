package org.example.ServiceLayer;

import org.example.EntityLayer.Exam;
import org.example.EntityLayer.Subject;
import org.example.ExceptionLayer.ExamNotFoundException;
import org.example.ExceptionLayer.StudentNotFoundException;
import org.example.RepositoryLayer.ExamRepository;
import org.example.RepositoryLayer.StudentRepository;
import org.example.RepositoryLayer.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Exam addExam(Integer  subjectId){
        Optional<Subject> subjectOptional=subjectRepository.findById(subjectId);

        if(subjectOptional.isEmpty()){
            throw new StudentNotFoundException("Subject is Not Found for this Exam");
        }

        Exam exam=new Exam(subjectOptional.get().getSubjectId(),
                subjectOptional.get().getName());
        examRepository.save(exam);
        subjectOptional.get().setExamId(exam.getExamId());
        subjectRepository.save(subjectOptional.get());
        return exam;
    }

    public Exam getExamById(int examId){
        Optional<Exam> examOpt= Optional.ofNullable(examRepository.findById(examId)
                .orElseThrow(() -> new ExamNotFoundException("Exam Not Found with the given examID.")));
        return examOpt.get();
    }

    public void deleteExamById(int examId){
        studentService.deleteExamRegistered(examId);
        examRepository.deleteById(examId);
    }

    public List<Exam> getAllExams(){
       return  examRepository.findAll();
    }


}
