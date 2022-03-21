package entity;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Person implements ICommon, Serializable {
    private String rollNumber;
    private String name;
    private boolean gender;
    private String dob;
    private String email;
    private String mobile;
    private String address;

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //display
    public void display() {
        System.out.printf(
                "| %10s | %16s | %5s | %12s | %28s | %12s | %12s |",
                rollNumber,
                name,
                gender ? "Nam" : "Nữ",
                dob,
                email,
                mobile,
                address
        );
    }

    public void input() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("\nEnter rollNumber: ");
            this.rollNumber = scanner.nextLine().trim();

            System.out.print("Enter name: ");
            this.name = scanner.nextLine().trim();


            System.out.print("Enter gender: ");
            this.gender = Boolean.parseBoolean(scanner.nextLine().trim());


            String dobRegex = "(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})";
            try {
                do {
                    System.out.print("Enter dob (DD/MM/YYYY): ");
                    this.dob = scanner.nextLine().trim();
                    if (dob.matches(dobRegex)) {
                        break;
                    }
                    System.out.println("Day of Birth is wrong format, please try again!");
                } while (true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            try {
                do {
                    System.out.print("Enter email: ");
                    this.email = scanner.nextLine().trim();
                    if (email.matches(emailRegex)) {
                        break;
                    }
                    System.out.println("Email is wrong, please try again!");
                } while (true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            String mobileRegex = "\\d{10}";
            try {
                do {
                    System.out.print("Enter mobile: ");
                    this.mobile = scanner.nextLine().trim();
                    if (mobile.matches(mobileRegex)) {
                        break;
                    }
                    System.out.println("Mobile number is wrong, please try again!");
                } while (true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Enter address: ");
            this.address = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
