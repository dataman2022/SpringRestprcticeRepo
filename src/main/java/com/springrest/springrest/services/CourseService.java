package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

// we have created service interface to provide data/information to 
//presentationlayer/controller layer(becouse controller cant generate data) 
public interface CourseService {

	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public void deleteCourse(long parseLong);
	public Course updateCourse(Course course);

}
