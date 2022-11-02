package com.course.courseServices;

import com.course.course_entity.CourseEntity;

import java.util.List;
import java.util.Optional;

public interface CourseServices {
    // now we have to make a method that will return list of courses.

    public List<CourseEntity> get_all_courses(); // runtime polymorphism
    // there is no body ,, so it will call child body.

    // Now make class and implements interface name

    public Optional<CourseEntity> getCourseByid(long courseId); // we provide course id as a long type


    public CourseEntity addCourse(CourseEntity course);

     public CourseEntity updateCourse(CourseEntity course);


    public void deletec(long parseLong);


}
