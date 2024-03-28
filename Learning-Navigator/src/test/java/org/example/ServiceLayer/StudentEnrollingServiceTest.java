package org.example.ServiceLayer;

import lombok.extern.slf4j.Slf4j;
import org.example.Dtos.StudentEnrollsSubjectDto;
import org.example.EntityLayer.Student;
import org.example.EntityLayer.Subject;
import org.example.RepositoryLayer.ExamRepository;
import org.example.RepositoryLayer.StudentRepository;
import org.example.RepositoryLayer.SubjectRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

@Slf4j
public class StudentEnrollingServiceTest {

    @InjectMocks
    private StudentEnrollingService studentEnrollingService;

    @Mock
    private StudentService studentService;

    @Mock
    private SubjectService subjectService;

    @Mock
    private ExamService examService;

    @Mock
    private ExamRepository examRepository;
    @Mock
    private SubjectRepository subjectRepository;
    @Mock
    private StudentRepository studentRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    public void enrollSubject() {

        Student student=new Student("kishore");
        student.setRegistrationId(1);


        Subject subject=new Subject("math");;
        subject.setSubjectId(2);

//        Exam exam=new Exam();
//        exam.setExamId(3);
//        exam.setSubjectId(2);
//        exam.setSubjectName("math");

        log.info("Student = {} ",student);

        when(studentService.getStudentById(1)).thenReturn(student);

        log.info("Subject = {} ",subject);

        when(subjectService.getSubjectById(2)).thenReturn(subject);

//        when(examService.getExamById(anyInt())).thenReturn(exam);

        StudentEnrollsSubjectDto studentEnrollsSubjectDto=studentEnrollingService.enrollSubject(1,2);

        Assert.assertEquals(studentEnrollsSubjectDto.getStudent().getRegistrationId(),new Integer(1));
        Assert.assertEquals(studentEnrollsSubjectDto.getSubject().getSubjectId(),new Integer(2));

    }

    @Test
    public void examRegisteration() {
    }
}