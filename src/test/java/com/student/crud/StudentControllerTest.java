package com.student.crud;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import com.student.crud.controller.StudentController;
import com.student.crud.dao.StudentDAO;
import com.student.crud.model.Student;
import com.sun.org.apache.xml.internal.security.Init;


@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
	@Mock
	private StudentDAO studentDAO;
	@InjectMocks
	private StudentController studentController = new StudentController();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void getStudents_JsonTest() throws Exception{
		Student student1 = new Student();
		student1.setStuNo("1");
		student1.setStufName("Ramesh");
		student1.setStulName("number 1");
		student1.setEmail("number 1");
		
		Student student2 = new Student();
		student2.setStuNo("2");
		student2.setStufName("Ramesh");
		student2.setStulName("number 1");
		student2.setEmail("number 1");
	

		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(student1);
		studentList.add(student2);
		when(studentDAO.getAllStudents()).thenReturn(studentList);
		List<Student> actualStudentList = studentController.getStudents_JSON();
		assertEquals(studentList, actualStudentList);
	}
	
	@Test
	public void addStudentTest() throws Exception{
		Student student1 = new Student();
		student1.setStuNo("1");
		student1.setStufName("Ramesh");
		student1.setStulName("number 1");
		student1.setEmail("number 1");
	
    	when(studentDAO.addStudent(student1)).thenReturn(student1);
		Student mockStudent = studentController.addStudent(student1);
		assertEquals(mockStudent, student1);
	}
	
	@Test
	public void deleteStudentTest() throws Exception{
		Student student1 = new Student();
		student1.setStuNo("1");
		student1.setStufName("Ramesh");
		student1.setStulName("number 1");
		student1.setEmail("number 1");
		
//		MockMvc
//	
//    	when(studentDAO.deleteStudent(student1.getStuNo(s)).thenReturn(student1);
//		Student mockStudent = studentController.deleteStudent(student1);
//		assertEquals(mockStudent, student1);
	}
	

}
