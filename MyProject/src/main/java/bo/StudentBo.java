package bo;

import entity.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentBo implements IMethod, Serializable {

    private List<Student> list;

    public StudentBo() {
        list = new ArrayList<>();
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public int getIndex(String rollNumber) {
        for (int i = 0; i < this.list.size(); ++i) {
            if (this.list.get(i).getRollNumber().equalsIgnoreCase(rollNumber.trim())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add() {
        Student student = new Student();
        student.input();
        return this.list.add(student);
    }

    @Override
    public boolean update(String rollNumber) {
        int index = getIndex(rollNumber);
        if (index >= 0) {
            Student student = new Student();
            student.input();
            list.set(index, student);
            return true;
        } else {
            System.out.println("Roll number not found");
        }
        return false;
    }

    @Override
    public boolean remove(String rollNumber) {
        int index = getIndex(rollNumber);
        if (index >= 0) {
            return list.remove(index) != null;
        }
        return false;
    }

    @Override
    public List search(String text) {
        int index = getIndex(text);
        if (index >= 0) {
            list.get(index).display();
        } else {
            System.out.println("Roll number not found");
        }


        return null;
    }

    @Override
    public void sort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1. Sort by roll number");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by mark");
        System.out.print("You choose: ");
        int flat = Integer.valueOf(scanner.nextLine().trim());

        switch (flat) {
            case 1:
                this.list.sort(Comparator.comparing(Student::getRollNumber));
                break;
            case 2:
                this.list.sort(Comparator.comparing(Student::getName));
                break;
            default:
                this.list.sort(Comparator.comparing(Student::getMark));
                break;
        }

    }

    @Override
    public void display() {
        this.list.forEach(Student::display);
    }

}
