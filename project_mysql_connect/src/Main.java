package Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Display welcome message and menu options
       // System.out.println("Welcome to my Database Application!");
       // System.out.println("Select an option from the menu to proceed.");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
      //  System.out.println("3. Find Student");
       // System.out.println("4. Update Student");
        System.out.println("3. Show All Students");
        System.out.println("0. Exit");
        System.out.println("Enter your choice (0-3): ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();

        while (choice != 0) {
            switch (choice) {
                case 1: {
                    System.out.println("Enter the name of the student:");
                    String name = input.nextLine();
                    Application.Services.insertData(name);
                    System.out.println();
                    break;
                }
                case 2:{
                    System.out.println("Enter the ID of the student to delete:");
                    int studentId = input.nextInt();
                    Services.deleteData(studentId);
                    System.out.println();
                    break;
                }
              /*  case 3:{
                    System.out.println("Enter the ID of the student to find:");
                    int studentId = input.nextInt();
                    Services.findStudent(studentId);
                    System.out.println();
                    break;
                }
                case 4:{
                    System.out.println("Enter the ID of the student to update:");
                    int studentId = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter the new name for the student:");
                    String newName = input.nextLine();
                    Services.updateStudent(studentId, newName);
                    System.out.println();
                    break;
                }*/
                case 3:{
                    Services.viewAllStudents();
                    System.out.println();
                    break;
                }
                default:
                    System.out.println("Invalid choice, please try again.");
                    System.out.println();
                    break;
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An error occurred while waiting: " + e.getMessage());
            }

            System.out.println("Select an option from the menu to proceed.");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
          //  System.out.println("3. Find Student");
           // System.out.println("4. Update Student");
            System.out.println("3. Show All Students");
            System.out.println("0. Exit");
            System.out.println("Enter your choice (0-3): ");
            choice = input.nextInt();
        }
    }
}