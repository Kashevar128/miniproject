package com.example.miniproject.services;

import com.example.miniproject.dtos.StudentDto;
import com.example.miniproject.entities.Student;
import com.example.miniproject.exceptions.ResourceNotFoundException;
import com.example.miniproject.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Студент с id: " + id + " не найден"));
    }

    public Student deleteById(Long id) {
        return studentRepository.deleteStudentById(id).orElseThrow(
                () -> new ResourceNotFoundException("Студент с id: " + id + " не найден и не может быть удален")
        );
    }

    @Transactional
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return studentRepository.getByName(student.getName());
    }

}
