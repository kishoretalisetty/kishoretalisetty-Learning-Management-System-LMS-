package org.example.ServiceLayer;

import org.example.EntityLayer.Student;
import org.example.EntityLayer.StudentEnrollSubject;
import org.example.EntityLayer.StudentExamRegistered;
import org.example.ExceptionLayer.StudentNotFoundException;
import org.example.RepositoryLayer.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(String name){
        Student student=new Student(name);
        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(int studentId){
        Optional<Student> studentOpt= studentRepository.findById(studentId);

        if(studentOpt.isEmpty())
         throw new StudentNotFoundException("Student Not Found with the given studentID.");
        Student ans=studentOpt.get();
        return ans;
    }

    public void deleteStudent(int studentId){
        studentRepository.deleteById(studentId);
    }

    public void deleteEnrolledSubject(int subjectId){
        List<Student> studentList=findAllStudents();
       for(Student st: studentList){
           if (st==null)continue;
           boolean flag=false;
           for(int i=0; i<st.getEnrolledSubjects().size(); i++){
                StudentEnrollSubject ses=st.getEnrolledSubjects().get(i);
               if(ses.getSubjectId()==subjectId){
                   flag=true;
                   st.getEnrolledSubjects().remove(ses);
                   i--;
               }
           }
           if(flag){
               studentRepository.save(st);
           }
       }

    }

    public List<Student> findAllStudents(){
      return   studentRepository.findAll();
    }

    public void deleteExamRegistered(int examId){
        List<Student> studentList=findAllStudents();
        for(Student st: studentList){
            boolean flag=false;
            for(int i=0; i<st.getRegisteredExams().size(); i++){
                StudentExamRegistered ser=st.getRegisteredExams().get(i);
                if(ser.getExamId()==examId){
                    flag=true;
                    st.getRegisteredExams().remove(ser);
                    i--;
                }
            }
            if(flag){
                studentRepository.save(st);
            }
        }
    }

}
