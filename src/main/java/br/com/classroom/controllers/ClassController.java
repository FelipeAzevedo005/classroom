package br.com.classroom.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.classroom.model.ClassOfStudents;
import br.com.classroom.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/all")
    public List<ClassOfStudents> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassOfStudents> getClassById(@PathVariable Long id) {
        return classService.getClassById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ClassOfStudents createClass(@RequestBody ClassOfStudents classOfStudents) {
        return classService.saveClass(classOfStudents);
    }

    @PostMapping("/enroll/{classId}/{studentId}")
    public ClassOfStudents enrollStudent(@PathVariable Long classId, @PathVariable Long studentId) {
        return classService.enrollStudent(classId, studentId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}