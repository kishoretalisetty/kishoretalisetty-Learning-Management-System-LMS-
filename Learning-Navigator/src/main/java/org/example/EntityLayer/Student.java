package org.example.EntityLayer;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registrationId;

    private String name;


    @ManyToMany(targetEntity =StudentEnrollSubject.class, cascade = CascadeType.ALL)
    private List<StudentEnrollSubject> enrolledSubjects;

    @ManyToMany( cascade = CascadeType.ALL)
    private List<StudentExamRegistered> registeredExams;

    public Student(String name){
        this.name=name;
        this.enrolledSubjects=new ArrayList<>();
        this.registeredExams=new ArrayList<>();
    }
}
