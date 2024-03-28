package org.example.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.EntityLayer.Student;
import org.example.EntityLayer.Subject;

@Getter
@Setter
@AllArgsConstructor
@Data

public class StudentEnrollsSubjectDto {

    private Student student;
    private Subject subject;

}
