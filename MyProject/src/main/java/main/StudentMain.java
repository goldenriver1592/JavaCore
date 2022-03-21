package main;

import bo.StudentBo;
import entity.Student;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentBo sb = new StudentBo();

        boolean flag = true;
        do {
            try {
                System.out.println("\n------- STUDENT MANAGE -------");
                System.out.println("1. Display list student");
                System.out.println("2. Add new student");
                System.out.println("3. Update student");
                System.out.println("4. Delete student");
                System.out.println("5. Search");
                System.out.println("6. Sort");
                System.out.println("7. Save data");
                System.out.println("8. Load data");
                System.out.println("9. Exit");

                System.out.print("Your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println("------------------------------");

                switch (choice) {
                    case 1:
                        if (sb.getList().isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            System.out.println("Student list:");
                            sb.display();
                        }
                        break;
                    case 2:
                        System.out.println("Add new student:");
                        sb.add();
                        break;
                    case 3:
                        System.out.print("Input Roll Number:");
                        sb.update(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Input Roll Number:");
                        sb.remove(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Input Roll Number:");
                        sb.search(scanner.nextLine());
                        break;
                    case 6:
                        sb.sort();
                        break;
                    case 7:
                        FileUtil.writeObject(sb.getList(), "data.txt");
                        System.out.println("Save data successfully!");
                        break;
                    case 8:
                        sb.setList((List<Student>) FileUtil.readObject("data.txt"));
                        System.out.println("Load data successfully!");
                        break;
                    case 9:
                        flag = false;
                        break;
                    default:
                        System.out.println("Only choose 1 - 9.");
                }

            } catch (Exception e) {
                System.out.println("Wrong format number!");
            }
        } while (flag);

    }
}
