package services;

import entites.Person;

public class AuthService {
    static PersonService userService = new PersonService();

    public static Person login(String email, String password) {
        Person user = userService.findOneByEmail(email);
        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public static boolean register(Person user) {
        return false;
    }

    public static void logout() {
        return;
    }
}
