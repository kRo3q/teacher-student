package com.example.student_teacher.repositories;

import com.example.student_teacher.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Student findByName(@Param("name") String studentName);

    Student findBySurname(@Param("surname") String studentSurname);

    void save(Student student);

    void deleteById(Long id);

    Page<Student> findAll(Pageable pageable);

    Student getReferenceById(Long id);
}
