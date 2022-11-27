package com.example.student_teacher.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "teacher")
public class Teacher {
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
    String subject;

    @ManyToMany (mappedBy = "teachers")
    List<Student> students;

    public Teacher() {
    }

    public Teacher(String name, String surname, Short age, String email, String subject) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.subject = subject;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void deleteStudent(Student student){
        students.remove(student);
    }
}
