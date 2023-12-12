package services;

import entites.Person;
import enums.Role;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonService implements Service<Person> {
    private final File file = new File("data\\persons.txt");
    private static final ArrayList<Person> users = new ArrayList<>();

    public PersonService() {
        loadDataFromFile();
    }

    @Override
    public void insert(Person user) {
        // Generate ID automatically
        Person lastUser = users.get(users.size() - 1);
        user.setId(lastUser.getId() + 1);

        // Implement insert logic here
        users.add(user);
        saveDataToFile();
    }
    @Override
    public ArrayList<Person> find() {
        // Implement find logic here
        return new ArrayList<>(users);
    }

    public static Person findOne(Integer id) {
        // Implement findOne logic here
        for (Person user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public Person findOneByEmail(String email) {
        for (Person user:users) {
            if(user.getEmail().equals(email))
                return user;
        }

        return null;
    }

    @Override
    public void delete(Person user) {
        // Implement delete logic here
        users.remove(user);
        saveDataToFile();
    }

    @Override
    public void update(Person user) {
        // Implement update logic here
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                saveDataToFile();
                return;
            }
        }
    }

    @Override
    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Person user : users) {
                writer.println(user.getId() + ", " + user.getName() + ", " + user.getEmail() + ", " + user.getPassword() + ", " + user.getRole());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadDataFromFile() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] userData = scanner.nextLine().split(", ");
                int id = Integer.parseInt(userData[0]);
                String name = userData[1];
                String email = userData[2];
                String password = userData[3];
                Role role = null;
                switch (userData[4]) {
                    case "ADMIN" -> role = Role.ADMIN;
                    case "LECTURER" -> role = Role.LECTURER;
                    case "STUDENT" -> role = Role.STUDENT;
                    case "USER" -> role = Role.USER;
                }
                // Assuming the Role enum is present in the User class
                Person person = new Person(id, name, email, password, role);
                users.add(person);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
