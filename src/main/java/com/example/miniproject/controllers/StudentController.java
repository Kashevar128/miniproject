package com.example.miniproject.controllers;

import com.example.miniproject.dtos.StudentDto;
import com.example.miniproject.dtos.StudentDtoSave;
import com.example.miniproject.entities.Student;
import com.example.miniproject.exceptions.AppError;
import com.example.miniproject.mappers.StudentMapper;
import com.example.miniproject.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Студенты", description = "Методы работы со студентами")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Operation(
            summary = "Запрос на получение списка студентов"
    )
    @GetMapping
    public List<StudentDto> findAllStudent() {
        return studentMapper.mapStudentListToStudentDtoList(studentService.findAll());
    }

    @Operation(
            summary = "Запрос на получение студента по id",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = StudentDto.class))
                    ),
                    @ApiResponse(
                            description = "Студент не найден", responseCode = "500",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable
                                     @Parameter(description = "Идентификатор студента",
                                             required = true) Long id) {
        return studentMapper.mapStudentToStudentDto(studentService.findById(id));
    }

    @Operation(
            summary = "Запрос на удаление студента по id",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = StudentDto.class))
                    ),
                    @ApiResponse(
                            description = "Студент не найден", responseCode = "500",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @DeleteMapping("/{id}")
    public StudentDto deleteStudentById(@PathVariable
                                        @Parameter(description = "Идентификатор студента",
                                                required = true) Long id) {
        return studentMapper.mapStudentToStudentDto(studentService.deleteById(id));
    }

    @Operation(
            summary = "Сохранение студента или создание нового",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = StudentDto.class))
                    )
            }
    )
    @PostMapping()
    public StudentDto updateStudentById(@RequestBody
                                        @Parameter(description = "Данные для создания нового студента",
                                                required = true) StudentDtoSave studentDtoSave) {
        Student student = studentService.saveStudent(studentMapper.mapStudentDtoSaveToStudent(studentDtoSave));
        return studentMapper.mapStudentToStudentDto(student);
    }


}