package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {

    private double mark;

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
    @Override
    public void display() {
        super.display();
        System.out.printf("%6s |\n", mark);
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);

        super.input();
        do {
            System.out.print("Enter mark: ");
            try {
                this.mark = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("Wrong format, try again");
            }
        } while (true);
    }
}

