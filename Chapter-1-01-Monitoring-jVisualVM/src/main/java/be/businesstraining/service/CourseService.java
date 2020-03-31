package be.businesstraining.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import be.businesstraining.dao.CourseDAO;
import be.businesstraining.domain.Course;


public class CourseService {
	
	private CourseDAO courseDAO = new CourseDAO();
	
	//Dummy cached data used only to simulate large
	//memory allocation
	@SuppressWarnings("unused")
	private byte[] cachedData = null; 
	
	public synchronized List<Course> getCourses() {
		
		//To simulate large memory allocation,
		//let's assume we are reading serialized cache data 
		//and storing it in cachedData member
		try {
			this.cachedData = generateDummyCachedData();
		} catch (IOException e) {
			//ignore
		}
		
		return courseDAO.getCourses();
	}
	
	private byte[] generateDummyCachedData() throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byte[] dummyData =  "Dummy cached data".getBytes();
		
		//write 100000 times
		for (int i = 0; i < 100000; i++)
			byteStream.write(dummyData);
		
		byte[] result = byteStream.toByteArray();
		byteStream.close();
		return result;
	}
 }
