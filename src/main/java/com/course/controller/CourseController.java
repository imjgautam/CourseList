package com.course.controller;

import com.course.courseServices.CourseServices;
import com.course.course_entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// step - 1
// we have to use annotation, to validate that this CourseController class is a controller class.
// by this method spring boot automatically
// -------------------------------------------------------------------------------------------------

@RestController // this is an annotation for controller class,  so we are making rest api so we call restcontroller
public class CourseController {



    //step - 2
    // Now,  we have to map our website according to our project.
    // so we make a method like ( localhost:8080/home)
    // "/home" when user hit this url.. something will appear on user screen. otherwise 404 http status will show


    @GetMapping("/home") // this is an annotation for get request mapping for url (localhost:8080/home)
    public String home(){
        return "this is home page";
    }

    // Now this is the project for storing courses details
    // if we want to show all courses inside database to user we have make course_entity package
    // inside course_entity package we will describe all the required field that is course id, course name, course decp.
    // so first go and make course_entity package inside com.course


    // -------------- after service package created --- then -------------
    // after successfully created services  class and interface ... now we have to make object of service class
    // step -1 declare the variable of parent class which is interface inside the service package
    @Autowired // it will indicate to spring boot that we require object for this interface accroding to dependency injection
    private CourseServices courseServices;


    // Now we do url mapping to get all courses
    @GetMapping("/courses")  // url "localhost:8080/courses"
    public List<CourseEntity> get_course_list(){
        // now we have created the object above and we will call the courses from the service class through object
        return this.courseServices.get_all_courses();
    }

    // now if all the courses is accessed through above url
    // now we have to make another url mapping to find particular courses through course id
    @GetMapping("/courses/{courseId}")  // here we have to pass the value of course id after /courses so we write inside {id}
    public Optional<CourseEntity> getCourseById(@PathVariable String courseId){ // @pathvariable is annotation to pass the id inside met
        return this.courseServices.getCourseByid(Long.parseLong(courseId));
    }

    // now we create course
    @PostMapping("/courses")  // we can add similar url but must have different request
    public  CourseEntity addCourse(@RequestBody CourseEntity course){ // here we adding course throgh body request and using entity and their object

        return  this.courseServices.addCourse(course);
    }

    // now we create update request
    @PutMapping("/courses")
    public  CourseEntity updateCourse(@RequestBody CourseEntity course)
    {
        return this.courseServices.updateCourse(course);
    }


    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String courseId){

        try {
             this.courseServices.deletec(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
