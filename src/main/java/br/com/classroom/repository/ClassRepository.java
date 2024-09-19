package br.com.classroom.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.classroom.model.ClassOfStudents;

@Repository
public interface ClassRepository extends JpaRepository<ClassOfStudents, Long>{
    
}
