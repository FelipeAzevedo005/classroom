package br.com.classroom.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.classroom.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
