package services;

import entites.Subject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SubjectService implements Service<Subject> {
    private final File file = new File("data\\subjects.txt");
    private static final ArrayList<Subject> subjects = new ArrayList<>();
    public SubjectService() {
        loadDataFromFile();
    }
    @Override
    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Subject subject : subjects) {
                // Customize this line based on the attributes of your Subject class
                writer.println(subject.getId() + ", " + subject.getName() + ", " +
                        subject.getStudentIds() + ", " + subject.getLecturerIds());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(Subject subject) {
        // Generate ID automatically
        Subject lastSubject = subjects.get(subjects.size() - 1);
        subject.setId(lastSubject.getId() + 1);

        // Implement insert logic here
        subjects.add(subject);
        saveDataToFile();
    }

    @Override
    public ArrayList<Subject> find() {
        return new ArrayList<>(subjects);
    }

    @Override
    public void delete(Subject subject) {
        subjects.remove(subject);
        saveDataToFile();
    }

    @Override
    public void update(Subject subject) {
        // Implement update logic here
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getId() == subject.getId()) {
                subjects.set(i, subject);
                saveDataToFile();
                return;
            }
        }
    }

    private void loadDataFromFile() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                // Customize this section based on the attributes of your Subject class
                String[] subjectData = scanner.nextLine().split(", ");
                int id = Integer.parseInt(subjectData[0]);
                String name = subjectData[1];
                String studentIdsData = subjectData[2];
                String lecturerIdsData = subjectData[3];

                studentIdsData = studentIdsData.replace("[", "");
                studentIdsData = studentIdsData.replace("]", "");
                String[] sIds = studentIdsData.split(", ");
                ArrayList<Integer> studentIds = new ArrayList<>();
                for (String sId : sIds) {
                    studentIds.add(Integer.parseInt(sId));
                }

                lecturerIdsData = lecturerIdsData.replace("[", "");
                lecturerIdsData = lecturerIdsData.replace("]", "");
                String[] lIds = lecturerIdsData.split(", ");
                ArrayList<Integer> lecturerIds = new ArrayList<>();
                for (String lId : lIds) {
                    lecturerIds.add(Integer.parseInt(lId));
                }

                Subject subject = new Subject(id, name, studentIds, lecturerIds);
                subjects.add(subject);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
