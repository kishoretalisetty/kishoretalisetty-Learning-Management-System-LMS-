package org.example.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.EntityLayer.Exam;
import org.example.EntityLayer.Student;

@Data
@AllArgsConstructor
//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRegisteredExamDto {
    private Student student;
    private Exam exam;
}
