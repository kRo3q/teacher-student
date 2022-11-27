package com.example.student_teacher.services;

import com.example.student_teacher.entities.Student;
import com.example.student_teacher.entities.Teacher;
import com.example.student_teacher.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Page<Teacher> getTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    public Teacher findByName(String teacherName) {
        return teacherRepository.findByName(teacherName);
    }

    public List<Student> getStudents(Long id) {
        return teacherRepository.getReferenceById(id).getStudents();
    }

    public Teacher findBySurname(String teacherSurname) {
        return teacherRepository.findBySurname(teacherSurname);
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public void addStudent(Long id, Student student) {
        teacherRepository.getReferenceById(id).addStudent(student);
    }

    public void deleteStudent(Long id, Student student) {
        teacherRepository.getReferenceById(id).deleteStudent(student);
    }
}
