package in.Student.dao;
import in.Student.dto.Student;
import in.Student.connection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAOIMP implements StudentDAO{
    private Connection con;
    public StudentDAOIMP() {
        this.con = Connector.requestConnection();
    }

    @Override
    public boolean insertStudent(Student s) {
        Scanner sc = new Scanner(System.in);
        String query = "insert into student values (0,?,?,?,?,?,?,sysdate())";
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setLong(2, s.getPhone());
            ps.setString(3, s.getMail());
            ps.setString(4, s.getBranch());
            ps.setString(5, s.getLoc());
            ps.setString(6, s.getPassword());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateStudent(Student s) {
        String query = "update student set name = ?, Phone = ?, Mail = ?, Branch = ?, Loc = ?, Password = ?,date=sysdate() where ID = ?";
        PreparedStatement ps = null;
        int i=0;
        try{
            ps = con.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setLong(2, s.getPhone());
            ps.setString(3, s.getMail());
            ps.setString(4, s.getBranch());
            ps.setString(5, s.getLoc());
            ps.setString(6, s.getPassword());
            ps.setInt(7, s.getId());  // Assuming `id` is the unique student identifier

            i = ps.executeUpdate();

            } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean deleteStudent(int id) {
        String query = "delete from student where id=?";
        PreparedStatement ps = null;
        int i =0;
        try {
            ps= con.prepareStatement(query);
            ps.setInt(1,id);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }if(i>0){
            return true;
        }else
        return false;
    }

    @Override
    public Student getStudent(String mail, String password) {
        Student s = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);
        String query = "select * from Student where mail = ? and Password = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,mail);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                s = new Student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("name"));
                s.setPhone(rs.getLong("Phone"));
                s.setMail(rs.getString("mail"));
                s.setBranch(rs.getString("Branch"));
                s.setLoc(rs.getString("Loc"));
                s.setPassword(rs.getString("Password"));
                s.setDate(rs.getString("Date"));
            }
        } catch (SQLException e) {
          e.printStackTrace();
        }

        return s;
    }

    @Override
    public boolean reset(String email, Long Phone) {
        PreparedStatement ps = null;
        Student s = null;
        String query = "update student set password = ? where email = ? and Phone = ?";
        int i=0;
        try {
            ps= con.prepareStatement(query);
            ps.setString(1,email);
            ps.setLong(2,Phone);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i>0){
            System.out.println("Password Changed Successfully");
            return true;
        }else{
            System.out.println("Try Again");
            return false;
        }
    }

    @Override
    public Student getStudent(long phone, String mail) {
        Student s = null;
        String query = "SELECT * FROM student WHERE phone = ? AND mail = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setLong(1, phone);
            ps.setString(2, mail);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Student();
                s.setId(rs.getInt("id")); // Adjust field names as per your table
                s.setName(rs.getString("name"));
                s.setPhone(rs.getLong("phone"));
                s.setMail(rs.getString("mail"));
                s.setBranch(rs.getString("Branch"));
                s.setLoc(rs.getString("Loc"));
                s.setPassword(rs.getString("password"));
                s.setDate(rs.getString("Date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }
    public boolean updateStudentPassword(Student s) {
        String query = "UPDATE student SET password = ? WHERE phone = ? AND mail = ?";
        int rowsAffected=0;

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, s.getPassword());
            ps.setLong(2, s.getPhone());
            ps.setString(3, s.getMail());

            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rowsAffected > 0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public ArrayList<Student> getStudent(String name) {
        ArrayList<Student> studentlist = new ArrayList<Student>();
        PreparedStatement ps = null;
        Student s = null;
        String query = "Select * from student where name = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                s = new Student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("Name"));
                s.setPhone(rs.getLong("Phone"));
                s.setMail(rs.getString("Mail"));
                s.setBranch(rs.getString("BRANCH"));
                s.setLoc(rs.getString("Loc"));
                s.setPassword(rs.getString("password"));
                s.setDate(rs.getString("date"));
                studentlist.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentlist;
    }

    @Override
    public ArrayList<Student> getStudent() {
        ArrayList<Student> studentlist = new ArrayList<Student>();
        PreparedStatement ps = null;
        Student s = null;
        String query = "Select * from student";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                s = new Student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("Name"));
                s.setPhone(rs.getLong("Phone"));
                s.setMail(rs.getString("Mail"));
                s.setBranch(rs.getString("BRANCH"));
                s.setLoc(rs.getString("Loc"));
                s.setPassword(rs.getString("password"));
                s.setDate(rs.getString("date"));
                studentlist.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentlist;
    }
}


