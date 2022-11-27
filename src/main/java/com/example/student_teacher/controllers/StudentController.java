package com.example.student_teacher.controllers;

import com.example.student_teacher.entities.Student;
import com.example.student_teacher.entities.Teacher;
import com.example.student_teacher.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("student/get")
    public Page<Student> getStudents(Pageable pageable) {
        return studentService.getStudents(pageable);
    }

    @PostMapping("student/add")
    public void addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("student/getbyname")
    public Student getStudentByName(String studentName){
        return studentService.findByName(studentName);
    }

    @GetMapping("student/getbysurname")
    public Student getStudentBySurname(String studentSurname){
        return studentService.findBySurname(studentSurname);
    }

    @GetMapping("student/getteachers/{id}")
    public List<Teacher> getTeachers(@PathVariable Long id){
        return studentService.getTeachers(id);
    }

    @PatchMapping("student/addteacher/{id}")
    public void addTeacher(@PathVariable Long id ,Teacher teacher){
        studentService.addTeacher(id,teacher);
    }
    @PatchMapping("student/deleteteacher/{id}")
    public void deleteTeacher(@PathVariable Long id, Teacher teacher){
        studentService.deleteTeacher(id,teacher);
    }

    @DeleteMapping("student/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
