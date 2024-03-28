package org.example.ControllerLayer;

import org.example.EntityLayer.Subject;
import org.example.ServiceLayer.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    public ResponseEntity<?> addSubject(@RequestParam(name = "name") String name){
        Subject subject= subjectService.addSubject(name);
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/subject")
    public ResponseEntity<?> getSubject(@RequestParam(name="subjectId") Integer subjectId){
        Subject subject=subjectService.getSubjectById(subjectId);
        return ResponseEntity.ok(subject);
    }

    @DeleteMapping("/subject")
    public void deleteSubject(@RequestParam(name="subjectId") Integer subjectId){
        subjectService.deleteSubjectById(subjectId);
    }

    @GetMapping("/getAllSubjects")
    public ResponseEntity<List<Subject>> getAllSubjects( ){
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }
}
