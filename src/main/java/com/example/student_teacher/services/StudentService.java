package com.example.student_teacher.services;

import com.example.student_teacher.entities.Student;
import com.example.student_teacher.entities.Teacher;
import com.example.student_teacher.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public List<Teacher> getTeachers(Long id) {
        return studentRepository.getReferenceById(id).getTeachers();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findByName(String studentName) {
        return studentRepository.findByName(studentName);
    }

    public Student findBySurname(String studentSurname) {
        return studentRepository.findBySurname(studentSurname);
    }

    public void addTeacher(Long id, Teacher teacher) {
        studentRepository.getReferenceById(id).addTeacher(teacher);
    }

    public void deleteTeacher(Long id, Teacher teacher) {
        studentRepository.getReferenceById(id).deleteTeacher(teacher);
    }
}
