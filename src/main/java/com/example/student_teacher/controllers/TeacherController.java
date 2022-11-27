package com.example.student_teacher.controllers;

import com.example.student_teacher.entities.Student;
import com.example.student_teacher.entities.Teacher;
import com.example.student_teacher.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("teacher/getteachers")
    public Page<Teacher> getTeachers(Pageable pageable) {
        return teacherService.getTeachers(pageable);
    }
    @PostMapping("teacher/add")
    public void addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }
    @GetMapping("teacher/getbyname")
    public Teacher getTeacherByName(String teacherName){
        return teacherService.findByName(teacherName);
    }
    @GetMapping("teacher/getbysurname")
    public Teacher getTeacherBySurname(String teacherSurname){
        return teacherService.findBySurname(teacherSurname);
    }

    @GetMapping("teacher/getstudents/{id}")
    public List<Student> getStudents(@PathVariable Long id){
        return teacherService.getStudents(id);
    }
    @PutMapping("teacher/addstudent/{id}")
    public void addStudent(@PathVariable Long id, Student student) {
        teacherService.addStudent(id,student);
    }

    @PutMapping("teacher/deletestudent/{id}")
    public void deleteStudent(@PathVariable Long id, Student student) {
        teacherService.deleteStudent(id,student);
    }


    @DeleteMapping("teacher/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        teacherService.deleteTeacher(id);
    }
}
