package org.example.EntityLayer;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    private String name;


    private int examId;

    public Subject(String name){
        this.name=name;
    }

}


//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)


//    @ManyToMany(targetEntity = )
//    private List<Integer> registeredStudents;