package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

// we have specify here that this class is work on service layer
@Service
public class CourseServiceimpl implements CourseService {
// by autowired spring boot create object internally(dont create by developer itself)
	@Autowired
	private CourseDao coursedao;
//	List<Course> list;

	
	CourseServiceimpl() {
//		list=new ArrayList<>();
//		list.add(new Course(145,"core java course","this contains basics of java"));
//		list.add(new Course(146,"core python course","this contains basics of java"));
	}

	@Override
	public List<Course> getCourses() {

		return coursedao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {

		
		
		
		//		Course c = null;
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		return coursedao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
        coursedao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		
		//list = this.list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
        Course entity=coursedao.getOne(parseLong);
		coursedao.delete(entity);
	}

	@Override
	public Course updateCourse(Course course) {
		coursedao.save(course);
		
		return course;
	}

}
