package be.businesstraining.dao;

import java.util.ArrayList;
import java.util.List;

import be.businesstraining.domain.Course;



public class CourseDAO {

	public List<Course> getCourses() {
		//No real database access takes place here. 
		//We will just simulate a long running database operation
				
		try {
			Thread.sleep(2000); //wait 2 seconds 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//return dummy/empty list
		return new ArrayList<>();
	}
}
