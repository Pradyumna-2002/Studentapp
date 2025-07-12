package in.Student.index;

import in.Student.dao.StudentDAO;
import in.Student.dao.StudentDAOIMP;
import in.Student.dto.Student;
import java.util.Scanner;

class updateStudent {
    public static void update(Student s) {
        StudentDAO sdao = new StudentDAOIMP();
        Scanner scn = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Profile Update Menu ---");
            System.out.println("1. Update Name");
            System.out.println("2. Update Phone");
            System.out.println("3. Update Email");
            System.out.println("4. Update Branch");
            System.out.println("5. Update Location");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scn.nextInt();
//            scn.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    s.setName(scn.next());
                    sdao.updateStudent(s);
                    System.out.println("✅ Name updated successfully!");
                    break;

                case 2:
                    System.out.print("Enter new phone number: ");
                    s.setPhone(scn.nextLong());
                    sdao.updateStudent(s);
                    System.out.println("✅ Phone number updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter new email: ");
                    s.setMail(scn.next());
                    sdao.updateStudent(s);
                    System.out.println("✅ Email updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter new branch: ");
                    s.setBranch(scn.next());
                    sdao.updateStudent(s);
                    System.out.println("✅ Branch updated successfully!");
                    break;

                case 5:
                    System.out.print("Enter new location: ");
                    s.setLoc(scn.next());
                    sdao.updateStudent(s);
                    System.out.println("✅ Location updated successfully!");
                    break;

                case 6:
                    System.out.println("👋 Exiting update menu. All changes saved.");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Please enter a number between 1 and 7.");
            }

        } while (choice != 6);
    }
}