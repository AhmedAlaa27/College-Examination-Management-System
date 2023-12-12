package entites;

import java.util.ArrayList;

public class Exam {
    private int id;
    private int subjectId;
    private double duration;
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    // Constructor
    public Exam(int id, int subjectId, double duration, ArrayList<String> questions, ArrayList<String> answers) {
        this.id = id;
        this.subjectId = subjectId;
        this.duration = duration;
        this.questions = questions;
        this.answers = answers;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for subjectId
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    // Getter and Setter for duration
    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Getter and Setter for questions
    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    // Getter and Setter for answers
    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    // Additional methods can be added as needed

    // Example: Method to add a question and its answer
    public void addQuestionAndAnswer(String question, String answer) {
        this.questions.add(question);
        this.answers.add(answer);
    }

    // Example: Method to display exam information
    public void displayExamInfo() {
        System.out.println("Exam ID: " + id);
        System.out.println("Subject ID: " + subjectId);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Questions: " + questions);
        System.out.println("Answers: " + answers);
    }
}

