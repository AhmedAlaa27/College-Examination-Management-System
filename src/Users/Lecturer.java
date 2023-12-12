package Users;

import entites.Person;
import enums.Role;

public class Lecturer extends Person {

    public Lecturer(Person user) {
        super(user.getId(), user.getName(), user.getEmail(),user.getPassword(), Role.LECTURER);
    }
    public Lecturer(Integer id, String name, String email, String password) {
        super(id, name, email,password,Role.LECTURER);
    }

}
