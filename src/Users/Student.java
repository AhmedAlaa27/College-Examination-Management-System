package Users;

import entites.Person;
import enums.Role;

public class Student extends Person {

    public Student(Person user) {
        super(user.getId(), user.getName(), user.getEmail(),user.getPassword(), Role.STUDENT);
    }
    public Student(Integer id, String name, String email, String password) {
        super(id, name, email, password,Role.STUDENT);
    }

}
