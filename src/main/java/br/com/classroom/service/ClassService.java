package br.com.classroom.service;

import br.com.classroom.model.ClassOfStudents;
import br.com.classroom.model.Student;
import br.com.classroom.repository.ClassRepository;
import br.com.classroom.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<ClassOfStudents> getAllClasses() {
        return classRepository.findAll();
    }

    public Optional<ClassOfStudents> getClassById(Long id) {
        return classRepository.findById(id);
    }

    public ClassOfStudents saveClass(ClassOfStudents classOfStudents) {
        return classRepository.save(classOfStudents);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    public ClassOfStudents enrollStudent(Long classId, Long studantId) {
        ClassOfStudents classOfStudents = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Student student = studentRepository.findById(studantId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        classOfStudents.getStudents().add(student);
        student.getClasses().add(classOfStudents);

        studentRepository.save(student);
        return classRepository.save(classOfStudents);
    }
}
