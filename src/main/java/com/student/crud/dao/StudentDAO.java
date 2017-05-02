package com.student.crud.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.student.crud.model.Student;

public class StudentDAO {

	private StudentMySQLAccess dao = new StudentMySQLAccess();

	public Student getStudent(String stuNo) throws Exception {
		return dao.getStudentInfo(stuNo);
	}

	public Student addStudent(Student stu) {
		return stu;
	}

	public Student updateStudent(Student stu) {
		return stu;
	}

	public void deleteStudent(String stuNo) throws Exception {
		dao.deleteStudent(stuNo);
	}

	public List<Student> getAllStudents() throws Exception {
		Map<String, Student> studentdataMap = dao.readDataBase();

		Collection<Student> c = studentdataMap.values();
		List<Student> list = new ArrayList<Student>();
		list.addAll(c);
		return list;
	}

	List<Student> list;
}
