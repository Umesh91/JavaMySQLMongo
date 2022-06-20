/**
 * 
 */
package com.MySQLHibernateAccess.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.MySQLHibernateAccess.entity.Student;
import com.MySQLHibernateAccess.util.HibernateUtil;

/**
 * @author A631954
 *
 */
public class StudentDAO 
{
	
	public void saveStudent(Student student)
	{
		Transaction transaction =null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			// start a transaction
			transaction= session.beginTransaction();
			// save the student object
            session.save(student);
            // commit transaction
            transaction.commit();
		}
		catch(Exception ex)
		{
			 if (transaction != null)
			 {
	                transaction.rollback();
	         }
			 ex.printStackTrace();
		}
	}
	
	public List <Student > getStudents()
	{
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			return session.createQuery("from Student",Student.class).list();
		}catch(Exception ex) {ex.printStackTrace();}
		return null;
		
		
	}

}
