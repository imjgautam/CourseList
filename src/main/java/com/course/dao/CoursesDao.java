package com.course.dao;

import com.course.course_entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoursesDao extends JpaRepository<CourseEntity, Long> {


    void delete(Optional<CourseEntity> c);
}
