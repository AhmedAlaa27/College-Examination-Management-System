package Users;

import entites.Person;
import enums.Role;
import services.PersonService;

import java.util.Scanner;

public class User extends Person {

    public User(Person user) {
        super(user.getId(), user.getName(), user.getEmail(),user.getPassword(), Role.USER);
    }
    public User(Integer id, String name, String email, String password) {
        super(id, name,email,password,Role.USER);
    }

    public void updateProfile(Person user) {

        // Remember that this class already has the logged-in user info above.

        PersonService personService = new PersonService();

        printLine();
        System.out.println(this.toString());
        printLine();

        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1) Update Username");
            System.out.println("2) Update Email");
            System.out.println("3) Update Password");
            System.out.println("4) Exit...");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    user.setName(username);
                    personService.update(user);
                    break;
                case 2:
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    user.setEmail(email);
                    personService.update(user);
                    break;
                case 3:
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Confirm Password: ");
                    String confirmPassword = scanner.nextLine();
                    if (password.equals(confirmPassword)) {
                        user.setPassword(password);
                        personService.update(user);
                    } else System.out.println("Password Does Not Match");
                    break;
                case 4:
                    System.exit(1);
                default:
                    System.out.println("Not A Valid Choice");
                    break;
            }
        }
    }
    public static void printLine() {
        System.out.println("======================================");
    }
}
