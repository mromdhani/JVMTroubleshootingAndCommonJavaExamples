package be.businesstraining.bean;

import java.util.List;

import be.businesstraining.domain.Course;
import be.businesstraining.service.CourseService;

public class CourseBean {
	private CourseService courseService = new CourseService();
	
	public List<Course> getCourses() {
		return courseService.getCourses();
	}
}
