package org.example.ExceptionLayer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectAlreadyEnrolledException extends RuntimeException{
    private String message;
}
