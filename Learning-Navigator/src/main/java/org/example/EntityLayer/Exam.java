package org.example.EntityLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@Entity
@Table(name = "exams")
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examId;

    private int subjectId;

    private String subjectName;

    public Exam(int subjectId,String name){
        this.subjectId=subjectId;
        this.subjectName=name;

    }

}

//    @ManyToOne(cascade = CascadeType.ALL)
//    private Subject subject;

//    @OneToOne(targetEntity =Subject.class, cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "examId")
//    private Subject subject;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Integer> enrolledStudents;
