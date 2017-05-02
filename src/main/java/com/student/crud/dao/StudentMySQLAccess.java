package com.student.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.student.crud.model.Student;

public class StudentMySQLAccess {

	private static final Map<String, Student> stuMap = new HashMap<String, Student>();
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public Map<String, Student> readDataBase() throws Exception {
		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_database?" + "user=root&password=database");

			System.out.println("I am testing ++++++++");
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from student_record");

			while (resultSet.next()) {
				String stuId = resultSet.getString("id");
				String fName = resultSet.getString("fname");
				String lName = resultSet.getString("lname");
				String stuEmail = resultSet.getString("email");

				Student stu = new Student(stuId, fName, lName, stuEmail);
				stuMap.put(stu.getStuNo(), stu);

			}
			return stuMap;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	public Student getStudentInfo(String sid) throws Exception {
		try {
			Student stu = null;
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_database?" + "user=root&password=database");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from student_record where id=" + sid);

			if (resultSet.next()) {
				String stuId = resultSet.getString("id");
				String fName = resultSet.getString("fname");
				String lName = resultSet.getString("lname");
				String stuEmail = resultSet.getString("email");
				stu = new Student(stuId, fName, lName, stuEmail);
			}

			return stu;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	public int deleteStudent(String sid) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_database?" + "user=root&password=database");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			int result = statement.executeUpdate("delete from student_record where id=" + sid);
			return result;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
