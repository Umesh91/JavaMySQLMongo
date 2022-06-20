package MySQLHibernateCRUD.MySQLHibernateCRUD;

import java.util.List;

import com.MySQLHibernateCRUD.dao.IStudentDao;
import com.MySQLHibernateCRUD.dao.StudentDAO;
import com.MySQLHibernateCRUD.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	IStudentDao studentDao = new StudentDAO();

    	//check the data stored in the table
        // test saveStudent
        Student student = new Student("Vijen", "Karthikeyan", "vk@gmail.com");
        studentDao.saveStudent(student);

        // test updateStudent
        student.setEmail("Jv@yahoo.co.in");
        studentDao.updateStudent(student);

        // test getStudentById
        //Student student2 = studentDao.getStudentById(student.getId());

        // test getAllStudents
        List < Student > students =studentDao.getAllStudents();
        students.forEach(student1 -> System.out.println(student1.getId()));

        // test deleteStudent
       // studentDao.deleteStudent(student.getId());
       
    }
}
