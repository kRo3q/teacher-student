package com.example.student_teacher.repositories;

import com.example.student_teacher.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends PagingAndSortingRepository<Teacher,Long> {
    Teacher findByName(@Param("name") String teacherName);

    Teacher findBySurname(@Param("surname") String teacherSurname);



    void deleteById(Long id);

    Page<Teacher> findAll(Pageable pageable);

    Teacher getReferenceById(Long id);

    void save(Teacher teacher);
}
