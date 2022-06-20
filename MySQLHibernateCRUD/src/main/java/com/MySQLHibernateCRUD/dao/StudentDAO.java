/**
 * 
 */
package com.MySQLHibernateCRUD.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.MySQLHibernateCRUD.entity.Student;
import com.MySQLHibernateCRUD.util.HibernateUtil;

/**
 * @author A631954
 *
 */
public class StudentDAO implements IStudentDao
{

	public void saveStudent(Student student) 
	{
		// TODO Auto-generated method stub
		Transaction transaction=null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			// start a transaction
			transaction= session.beginTransaction();
			// save the student object
		    session.save(student);
		   // commit transaction
		    transaction.commit();
		}catch(Exception ex)
		{
			 if (transaction != null)
			 {
	                transaction.rollback();
	         }
			 ex.printStackTrace();
		}
		
		 
	}

	public void updateStudent(Student student)
	{
		// TODO Auto-generated method stub
		Transaction transaction=null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			// start a transaction
			transaction= session.beginTransaction();
			// save the student object
		    session.saveOrUpdate(student);
		   // commit transaction
		    transaction.commit();
		}catch(Exception ex)
		{
			 if (transaction != null)
			 {
	                transaction.rollback();
	         }
			 ex.printStackTrace();
		}
	}

	public Student getStudentById(long id) 
	{
		// TODO Auto-generated method stub
		Transaction transaction=null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			// start a transaction
			transaction= session.beginTransaction();
			// save the student object
		    session.get(Student.class,id);
		   // commit transaction
		    transaction.commit();
		}catch(Exception ex)
		{
			 if (transaction != null)
			 {
	                transaction.rollback();
	         }
			 ex.printStackTrace();
		}
		return student;
	}

	public List<Student> getAllStudents() 
	{
		// TODO Auto-generated method stub
		Transaction transaction = null;
        List < Student > students = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            students = session.createQuery("from Student").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return students;
	}

	public void deleteStudent(long id) 
	{
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            student = session.get(Student.class, id);
            // get student object
            session.delete(student);
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}
	

}
