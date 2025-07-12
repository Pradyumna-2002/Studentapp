package in.Student.index;

import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to my Student Application");
        do {
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Forgot Password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    Signup.signup();
                    break;
                }
                case 2: {
                    login.Login();
                    break;
                }
                case 3: {
                    ForgotPassword.forgotpassword();
                    break;
                }
                case 4: {
                    System.out.println("Application closed. Goodbye!");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while (choice != 4);
        sc.close();
    }
}