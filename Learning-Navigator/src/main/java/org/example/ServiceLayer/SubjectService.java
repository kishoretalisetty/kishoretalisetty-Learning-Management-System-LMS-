package org.example.ServiceLayer;

import org.example.EntityLayer.Subject;
import org.example.ExceptionLayer.SubjectNotFoundException;
import org.example.RepositoryLayer.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private  StudentService studentService;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ExamService examService;

    public Subject addSubject(String name){
        Subject subject=new Subject(name);
        Subject sub=subjectRepository.save(subject);
        return sub;
    }

    public Subject getSubjectById(int subjectId){
        Optional<Subject> subjectOpt= Optional.ofNullable(subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException("Subject Not Found with the given studentID.")));

        return subjectOpt.get();
    }

    public void deleteSubjectById(int subjectId){
        Subject subject=getSubjectById(subjectId);

        studentService.deleteEnrolledSubject(subjectId);

        examService.deleteExamById(subject.getExamId());
        subjectRepository.deleteById(subjectId);

    }

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
}
