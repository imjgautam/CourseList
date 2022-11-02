package com.course.courseServices;

import com.course.course_entity.CourseEntity;
import com.course.dao.CoursesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // to indicate the spring boot that we are working on service layer that provide implementation
public final class CourseServicesImplementation implements CourseServices{
    @Autowired
    public CoursesDao coursesDao;

    //Step -1 this step can be optional ... here we are creating list of courses adding to temporary list // u can also add manually in database
   // List<CourseEntity> l;
    // now make a constructor
    public CourseServicesImplementation(){
//        l = new ArrayList<>();
//        l.add(new CourseEntity(100, "This is a java course", "You will learn basic java concept"));
//        l.add(new CourseEntity(101, "This is advance java course", "you will learn advance java concept for application development"));
//        l.add(new CourseEntity(200 , "This is database course", "you will learn here about database and their functionality"));
        // step 2 - go to controller and call the services you created here.
    }
    // after implementation of interface inside class we have to use interface methods and override list of courses method
    @Override
    public List<CourseEntity> get_all_courses() {
        //return l;
        return coursesDao.findAll(); // it will return all the item inisde the list , it will handle throgh the get all course method.
        // now we r using JPA
    }
    @Override

    public Optional<CourseEntity> getCourseByid(long courseId){
        // we will loop inside the above list
//        CourseEntity ce=null;
//        for(CourseEntity c : l)
//        {
//            if(c.getCourse_id()==courseId)
//            {
//                ce=c;
//                break;
//            }
//        }
        return coursesDao.findById(courseId);
    }

    @Override
    public CourseEntity addCourse(CourseEntity course) {
//
//        l.add(course);
//        return course;
        coursesDao.save(course);
        return course;
    }

    @Override
    public CourseEntity updateCourse(CourseEntity course) {

//        for (CourseEntity c : l)
//        {
//            if(c.getCourse_id()==course.getCourse_id())
//            {
//                c.setCourse_title(course.getCourse_title());
//                c.setCourse_description(course.getCourse_description());
//            }
//        }
//
//        return course;

        coursesDao.save(course);
        return course;
    }

    @Override
    public void deletec(long parseLong) {
        // l=this.l.stream().filter(e->e.getCourse_id()!=parseLong).collect(Collectors.toList());
        //Optional<CourseEntity> delcourse = coursesDao.findById(parseLong);;
        Optional<CourseEntity> c = coursesDao.findById(parseLong);
        coursesDao.delete(c);
    }

}
