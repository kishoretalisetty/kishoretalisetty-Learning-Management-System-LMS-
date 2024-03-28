package org.example.ExceptionLayer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentNotEnrolledTheSubjectException extends RuntimeException {
    private String message;
}
