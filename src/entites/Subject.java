package entites;

import java.util.ArrayList;

public class Subject {
    private int id;
    private String name;
    private ArrayList<Integer> studentIds;
    private ArrayList<Integer> lecturerIds;

    // Constructor
    public Subject(int id, String name, ArrayList<Integer> studentIds, ArrayList<Integer> lecturerIds) {
        this.id = id;
        this.name = name;
        this.studentIds = studentIds;
        this.lecturerIds = lecturerIds;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for studentIds
    public ArrayList<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(ArrayList<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    // Getter and Setter for lecturerIds
    public ArrayList<Integer> getLecturerIds() {
        return lecturerIds;
    }

    public void setLecturerIds(ArrayList<Integer> lecturerIds) {
        this.lecturerIds = lecturerIds;
    }

    // Additional methods can be added as needed

    // Example: Method to add a student ID
    public void addStudentId(int studentId) {
        this.studentIds.add(studentId);
    }

    // Example: Method to add a lecturer ID
    public void addLecturerId(int lecturerId) {
        this.lecturerIds.add(lecturerId);
    }

    // Example: Method to display subject information
    public void displaySubjectInfo() {
        System.out.println("Subject ID: " + id);
        System.out.println("Subject Name: " + name);
        System.out.println("Student IDs: " + studentIds);
        System.out.println("Lecturer IDs: " + lecturerIds);
    }
}

