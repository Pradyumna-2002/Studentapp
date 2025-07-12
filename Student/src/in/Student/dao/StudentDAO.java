package in.Student.dao;
import in.Student.dto.Student;
import java.util.ArrayList;
public interface StudentDAO {
//    JDBC Declarations
    public boolean insertStudent(Student s);
    public boolean updateStudent(Student s);
    public boolean deleteStudent(int id);
    public Student getStudent(String name,String password);
    public boolean reset(String email,Long Phone);
    public Student getStudent(long phone,String mail);
    public ArrayList<Student> getStudent(String name);
    public ArrayList<Student> getStudent();
}
