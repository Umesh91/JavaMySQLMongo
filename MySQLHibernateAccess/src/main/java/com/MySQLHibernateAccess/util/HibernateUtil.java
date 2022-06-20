/**
 * 
 */
package com.MySQLHibernateAccess.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.MySQLHibernateAccess.entity.Student;

/**
 * @author A631954
 *
 */
public class HibernateUtil 
{
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() 
	{
		if(sessionFactory == null)
		{
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings=new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "Shree@#919");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Student.class);
				ServiceRegistry registry=new StandardServiceRegistryBuilder().
						applySettings(configuration.getProperties()).build();
				sessionFactory=configuration.buildSessionFactory(registry);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            
		}
		return sessionFactory;
	}
	

}
