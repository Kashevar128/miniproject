package com.example.miniproject.repositories;

import com.example.miniproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    default Optional<Student> deleteStudentById(Long id) {
        Optional<Student> student = this.findById(id);
        deleteById(id);
        return student;
    }

    void deleteById(Long id);

    Student getByName(String name);

}
