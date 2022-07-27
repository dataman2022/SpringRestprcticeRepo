package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Course;
//JpaRepository== it have all functinality regarding insert,update ,delete
// fetch data from/to database
public interface CourseDao extends JpaRepository<Course,Long>{

	
}
