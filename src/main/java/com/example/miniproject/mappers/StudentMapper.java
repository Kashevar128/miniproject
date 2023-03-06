package com.example.miniproject.mappers;

import com.example.miniproject.dtos.StudentDto;
import com.example.miniproject.dtos.StudentDtoSave;
import com.example.miniproject.entities.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapper {

    public StudentDto mapStudentToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        return studentDto;
    }

    public Student mapStudentDtoSaveToStudent(StudentDtoSave studentDtoSave) {
        Student student = new Student();
        student.setName(studentDtoSave.getName());
        student.setAge(studentDtoSave.getAge());
        return student;
    }

    public List<StudentDto> mapStudentListToStudentDtoList(List<Student> studentList) {
        return studentList.stream()
                .map(this::mapStudentToStudentDto).toList();
    }
}
