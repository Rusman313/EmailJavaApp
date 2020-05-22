import java.util.Scanner;

public class Email {
    // making it private (Encapsulation) will be accessed by methods
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailBoxCapacity = 500;
    private String altEmail;
    private int defaultPassLength = 10;
    private String companySuffix = "company.com";

    // constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
       //System.out.println("Email created: " + this.firstName + this.lastName);
        // Calls method asking for department and returns department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        // call a method that returns a random password
        this.password = randomPassword(defaultPassLength);
        System.out.println("Your default password is: " + this.password);
        // combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        //System.out.println("Your email is: " + email);

    }

    // Ask for the department ( method that asks for dept and returns dept)
    private String setDepartment() {
        System.out.println(
                "New Employee " + firstName +  "\nDEPARTMENT CODES:\n1 - for Sales\n2 - for Development\n3 - for Accounting\n0 - for none\nEnter the department code:");
        Scanner scan = new Scanner(System.in);
        int deptchoice = scan.nextInt();
        if (deptchoice == 1) {
            return "Sales";
        } else if (deptchoice == 2) {
            return "Dev";
        } else if (deptchoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    // generate random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // set the alternate email
    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    // change the password
    public void changePass(String password) {
        this.password = password;
    }

    // getters
    public int getMailboxCap() {
        return mailBoxCapacity;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailBoxCapacity + "GB"; 
    }
}