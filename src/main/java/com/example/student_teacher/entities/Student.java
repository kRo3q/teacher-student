package com.example.student_teacher.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 3)
    String name;
    String surname;
    @Min(18)
    Short age;
    @Email
    String email;
    String fieldOfStudy;

    @ManyToMany
    @JoinTable(
            name = "teacher_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    List<Teacher> teachers;

    public Student() {
    }

    public Student(String name, String surname, Short age, String email, String fieldOfStudy, List<Teacher> teachers) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.fieldOfStudy = fieldOfStudy;
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public void deleteTeacher(Teacher teacher){
        teachers.remove(teacher);
    }
}
