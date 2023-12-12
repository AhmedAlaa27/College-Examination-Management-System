package services;

import entites.Exam;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamService implements Service<Exam> {
    private final File file = new File("data\\exams.txt");
    private static final ArrayList<Exam> exams = new ArrayList<>();
    public ExamService() {
        loadDataFromFile();
    }
    @Override
    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Exam exam : exams) {
                writer.println(exam.getId() + ", " + exam.getSubjectId() + ", " + exam.getDuration() + ", " +
                        exam.getQuestions() + ", " + exam.getAnswers());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(Exam exam) {
        // Generate ID automatically
        Exam lastExam = exams.get(exams.size() - 1);
        exam.setId(lastExam.getId() + 1);

        // Implement insert logic here
        exams.add(exam);
        saveDataToFile();
    }

    @Override
    public ArrayList<Exam> find() {
        return new ArrayList<>(exams);
    }

    @Override
    public void delete(Exam exam) {
        exams.remove(exam);
        saveDataToFile();
    }

    @Override
    public void update(Exam exam) {
        // Implement update logic here
        for (int i = 0; i < exams.size(); i++) {
            if (exams.get(i).getId() == exam.getId()) {
                exams.set(i, exam);
                saveDataToFile();
                return;
            }
        }
    }

    private void loadDataFromFile() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] examData = scanner.nextLine().split(", ");
                int id = Integer.parseInt(examData[0]);
                int sub_id = Integer.parseInt(examData[1]);
                double duration = Double.parseDouble(examData[2]);
                String questionsData = examData[3];
                String answersData = examData[4];

                questionsData = questionsData.replace("[", "");
                questionsData = questionsData.replace("]", "");
                String[] q = questionsData.split(", ");
                ArrayList<String> questions = new ArrayList<>();
                for (String question : q) {
                    questions.add(question);
                }

                answersData = answersData.replace("[", "");
                answersData = answersData.replace("]", "");
                String[] a = answersData.split(", ");
                ArrayList<String> answers = new ArrayList<>();
                for (String answer : a) {
                    answers.add(answer);
                }

                Exam exam = new Exam(id, sub_id, duration, questions, answers);
                exams.add(exam);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
