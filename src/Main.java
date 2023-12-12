import Users.Admin;
import Users.Lecturer;
import Users.Student;
import Users.User;
import entites.Person;
import services.AuthService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String email, password;

        printLine();
        System.out.println("Welcome To College Examination Management System");
        System.out.println("Please login");
        printLine();

        System.out.print("Email : ");
        email = scanner.nextLine();

        System.out.print("Password : ");
        password = scanner.nextLine();

        Person person = AuthService.login(email,password);

        if(person == null) {
            System.out.println("Login failed");
            System.exit(0);
        }

        System.out.println(person.toString());
        printLine();

        switch (person.getRole()) {
            case ADMIN -> {
                adminView(person);
            }
            case LECTURER -> {
                lecturerView(person);
            }
            case STUDENT -> {
                studentView(person);
            }
            case USER -> {
                userView(person);
            }
        }
    }
    public static void adminView(Person person) {
        Admin admin = new Admin(person);
        //write admin view and actions
        System.out.println("Admin");
    }

    public static void lecturerView(Person person) {
        Lecturer lecturer = new Lecturer(person);
        // Write tester view and actions
        System.out.println("Lecturer");
    }

    public static void studentView(Person person) {
        Student student = new Student(person);
        // Write developer view and actions
        System.out.println("Student");
    }

    public static void userView(Person person) {
        User user = new User(person);
        // Write developer view and actions
        System.out.println("1) Update Profile");
        System.out.println("2) Logout");
        int choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1 -> user.updateProfile(user);
            case 2 -> System.exit(1); // it should be the logout in AuthService
        }
    }

    public static void printLine() {
        System.out.println("======================================");
    }
}