package org.example.EntityLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEnrollSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sesId;
    private int studentId;
    private int subjectId;

    public StudentEnrollSubject(int studentId, int subjectId){
        this.studentId=studentId;
        this.subjectId=subjectId;
    }

}
