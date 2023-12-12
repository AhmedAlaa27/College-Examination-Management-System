package Users;

import entites.Person;
import enums.Role;

public class Admin extends Person {
    public Admin(Person user) {
        super(user.getId(), user.getName(), user.getEmail(),user.getPassword(), Role.ADMIN);
    }

    public Admin(Integer id, String name, String email,String password) {
        super(id, name, email,password, Role.ADMIN);
    }
    public static void printLine() {
        System.out.println("======================================");
    }
}
