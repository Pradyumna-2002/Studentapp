package in.Student.index;

import in.Student.dao.StudentDAO;
import in.Student.dao.StudentDAOIMP;
import in.Student.dto.Student;

import java.util.Scanner;

public class ForgotPassword {
    public static void forgotpassword() {
        Scanner scan = new Scanner(System.in);
        StudentDAO sdao = new StudentDAOIMP();

        System.out.println("Enter the phone number:");
        Long phone = scan.nextLong();

        System.out.println("Enter the email:");
        String mail = scan.next();

        // Attempt to fetch the student record using the provided phone and email
        Student s = sdao.getStudent(phone, mail);

        if (s != null) {
            // Safely compare values, avoiding NullPointerException
            if (s.getMail().equals(mail) && s.getPhone()==(phone)) {
                System.out.println("Enter the new password:");
                String newPassword = scan.next();
                s.setPassword(newPassword);
                boolean updated = sdao.updateStudent(s);
                if (updated) {
                    System.out.println("Password updated successfully.");
                } else {
                    System.out.println("Password update failed. Try again.");
                }
            } else {
                System.out.println("Provided credentials don't match our records.");
            }
        } else {
            System.out.println("No student found with the provided details.");
        }
    }
}