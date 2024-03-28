package org.example.ExceptionLayer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamAlreadyRegistedException extends RuntimeException{
    private String message;
}
