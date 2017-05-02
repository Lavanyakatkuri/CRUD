package com.student.crud.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.student.crud.dao.StudentDAO;
import com.student.crud.model.Student;

@Path("/students")
@Produces({ MediaType.APPLICATION_JSON })
public class StudentController {

	StudentDAO studentDAO = new StudentDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Student> getStudents_JSON() throws Exception {
		List<Student> listOfStudents = studentDAO.getAllStudents();
		return listOfStudents;
	}

	@GET
	@Path("/{stuNo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Student getStudent(@PathParam("stuNo") String StuNo) throws Exception {
		return studentDAO.getStudent(StuNo);
	}

	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Student addStudent(Student stu) {
		return studentDAO.addStudent(stu);
	}


	@DELETE
	@Path("/delete/{stuNo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void deleteStudent(@PathParam("stuNo") String stuNo) throws Exception {
		studentDAO.deleteStudent(stuNo);
	}

}
