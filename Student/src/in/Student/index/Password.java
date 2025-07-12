package in.Student.index;

import in.Student.dao.StudentDAO;
import in.Student.dao.StudentDAOIMP;
import in.Student.dto.Student;

import java.util.Scanner;

public class Password {
    public static void reset(Student s){
        Scanner scan = new Scanner(System.in);
        StudentDAO sdao = new StudentDAOIMP();
        System.out.println("Enter the email");
        String mail = scan.next();
        System.out.println("Enter the phone number");
        Long Phone = scan.nextLong();
        if(s.getMail().equals(mail)){
            if(s.getPhone() == Phone){
                System.out.println("Enter the new Password");
                String newPassword = scan.next();
                s.setPassword(newPassword);
                sdao.updateStudent(s);
            }else{
                System.out.println("Try again");
            }
        }else{
            System.out.println("exit");
        }
    }
}
