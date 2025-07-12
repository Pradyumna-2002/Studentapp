package in.Student.index;

import in.Student.dao.StudentDAO;
import in.Student.dao.StudentDAOIMP;
import in.Student.dto.Student;

import java.util.Scanner;

public class Signup {
        public static void signup() {
            Scanner sc = new Scanner(System.in);
            StudentDAO sdao = new StudentDAOIMP();
            Student s = new Student();
            System.out.println("<---Student Signup--->");
            System.out.println("enter the name");
            //String name =sc.next();
            //s.setName(name);  insted of this we write
            s.setName(sc.next());
            System.out.println("enter the phone:");
            s.setPhone(sc.nextLong());
            System.out.println("enter the mail ID:");
            s.setMail(sc.next());
            System.out.println("enter the Branch:");
            s.setBranch(sc.next());
//            sc.nextLine();
            System.out.println("enter the Location:");
            s.setLoc(sc.next());
            System.out.println("enter the Password:");
            String Password = sc.next();
            System.out.println("Conform a password:");
            String ConformPassword = sc.next();

            if(Password.equals(ConformPassword)) {
                s.setPassword(ConformPassword);
                //validating and Conforming password
                boolean res =sdao.insertStudent(s);
                if(res) {
                    System.out.println("Data added Successfully");
                }
                else{
                    System.out.println("Failed to create a account!");
                }
            }else {
                System.out.println("password MisMatch");
            }
        }

    }

