package com.course.course_entity;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")
public class CourseEntity {

    // step 1 -- define required fields

    @Id
    @GeneratedValue
    private long course_id;
    private String course_title;
    private String course_description;


    // step-2 Now add getter setter constructor for every field using above
    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    // step -3 Generate constructor using fields.
    public CourseEntity(long course_id, String course_title, String course_description) {
        super();
        this.course_id = course_id;
        this.course_title = course_title;
        this.course_description = course_description;
    }

    // step-4 .. create default constructor using super class
    public CourseEntity() {
        super();
    }

    // step - 5 .. create toString method and override it by override annotation // all done go to controller for get all courses.



    @Override
    public String toString() {
        return "CourseEntity{" +
                "course_id=" + course_id +
                ", course_title='" + course_title + '\'' +
                ", course_description='" + course_description + '\'' +
                '}';
    }
    // Now create a course_services package that will help to get all courses from the database.
    // inside course service package create an interface for abstract methods.
}
