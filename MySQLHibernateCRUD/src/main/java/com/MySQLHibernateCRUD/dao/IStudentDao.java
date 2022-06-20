/**
 * 
 */
package com.MySQLHibernateCRUD.dao;

import java.util.List;

import com.MySQLHibernateCRUD.entity.Student;

/**
 * @author A631954
 *
 */
public interface IStudentDao 
{
	void saveStudent(Student student);

	void updateStudent(Student student);

    Student getStudentById(long id);

    List<Student> getAllStudents();

    void deleteStudent(long id);

}
