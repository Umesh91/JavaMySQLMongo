package MySQLHibernateAccess.MySQLHibernateAccess;

import java.util.List;

import com.MySQLHibernateAccess.DAO.StudentDAO;
import com.MySQLHibernateAccess.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentDAO studentDAO= new StudentDAO();
    	Student student= new Student("Ranjeet","Agnihotri","ragnihotri@gmail.com");
    	studentDAO.saveStudent(student);
    	
    	List<Student > students=studentDAO.getStudents();
    	students.forEach(s -> System.out.println(s.getName()));
        //System.out.println( "Hello World!" );
    }
}
