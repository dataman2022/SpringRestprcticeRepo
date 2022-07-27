package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.services.CourseServiceimpl;

@RestController
public class MyController {

	// autowired is used to create object by springboot not by programmer(dependency
	// injection)
	// create object of implementaion class of this interface and inject it
	// to the reference variable(loose coupling)
	@Autowired
	private CourseService courseservice;

	@GetMapping("/home")
	public String home() {
		return "hii i am anuj";
	}

// get all the courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseservice.getCourses();

	}

//  create a method to return single course(GET /course/{course id})
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}

// create to add the course in the list
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
	}

	// delete the course
	@DeleteMapping("/courses/{courseId}")
   public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
	   try {
		   this.courseservice.deleteCourse(Long.parseLong(courseId));
		   return new ResponseEntity<>(HttpStatus.OK);
	   }catch(Exception e) {
		   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}

	@PutMapping("/courses")
   public Course updateCourse(@RequestBody Course course) {
	return this.courseservice.updateCourse(course);
		
	}
   
   
}
