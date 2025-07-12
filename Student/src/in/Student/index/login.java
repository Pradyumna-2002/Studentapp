package in.Student.index;

import in.Student.dao.StudentDAO;
import in.Student.dao.StudentDAOIMP;
import in.Student.dto.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class login {
    public static  void Login(){
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        StudentDAO sdao = new StudentDAOIMP();
        System.out.println("Enter your Mail");
        String mail = scan.next();
        System.out.println("Enter your Password");
        String Pass = scan.next();
        Student a = sdao.getStudent(mail,Pass);
        if(a!=null){
            System.out.println("Login sucessfull: " + a.getName());
            do {
                System.out.println("1. view data");
                System.out.println("2. search user");
                System.out.println("3. update account");
                System.out.println("4. password reset");
                System.out.println("5. Back to main menu");
                if (a.getId() == 3) {
                    System.out.println("6. view all user:");
                    System.out.println("7. delete the user");
                }
                System.out.println("Enter Your choice");
                Scanner sc = new Scanner(System.in);
                    choice = sc.nextInt();
                    switch(choice) {
                        case 1: {
                            System.out.println(a);
                            break;
                        }
                        case 2: {
                            System.out.println("Enter your name");
                            String name = scan.next();
                            ArrayList<Student> sl = sdao.getStudent(name);
                            for(Student s1 : sl){
                                System.out.println("Student Id: " + s1.getId());
                                System.out.println("Student name: " + s1.getName());
                                System.out.println("Student Branch: " + s1.getBranch());
                                System.out.println("Student Location: " + s1.getLoc());
                                System.out.println("===================================");
                            }
                            break;
                        }
                        case 3: {
                            updateStudent.update(a);
                            break;
                        }
                        case 4: {
                            Password.reset(a);
                            break;
                        }
                        case 5: {
                            System.out.println("Back to main menu");
                            break;
                        }
                        case 6: {
                            ArrayList<Student> studentlist = sdao.getStudent();
                            int length =studentlist.size()-1;
                            for(int i=0;i<length ;i++) {
                                System.out.print(studentlist.get(i));
                                System.out.println();
                            }
                            break;
                        }
                        case 7: {
                            System.out.println("Enter your id:");
                            int id = sc.nextInt();
                            boolean res = sdao.deleteStudent(id);
                            if(res){
                                System.out.println("Deleted Sucessfully");
                            }else{
                                System.out.println("Deleted Unsucessfully");
                            }
                            break;
                        }
                        default:
                            System.out.println("Back to main menu");
                    }
            }while (choice != 5);
        }else{
            System.out.println("Try again");
        }
    }
}
