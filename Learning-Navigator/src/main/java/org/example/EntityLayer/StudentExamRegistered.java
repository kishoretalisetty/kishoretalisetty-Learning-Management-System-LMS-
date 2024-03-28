package org.example.EntityLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExamRegistered {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int seid;
    
    private int studentId;
    
    private int examId;
    
    private int subjectId;

    public StudentExamRegistered(int studentId, int examId, int subjectId) {
        this.studentId=studentId;
        this.examId=examId;
        this.subjectId=subjectId;
    }
}
