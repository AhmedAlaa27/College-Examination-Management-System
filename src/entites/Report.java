package entites;

public class Report {
    private int id;
    private int lecturerId;
    private int studentId;
    private String reportInfo;

    // Constructor
    public Report(int id, int lecturerId, int studentId, String reportInfo) {
        this.id = id;
        this.lecturerId = lecturerId;
        this.studentId = studentId;
        this.reportInfo = reportInfo;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for lecturerId
    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    // Getter and Setter for studentId
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter and Setter for reportInfo
    public String getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(String reportInfo) {
        this.reportInfo = reportInfo;
    }

    // Additional methods can be added as needed

    // Example: Method to display report information
    public void displayReportInfo() {
        System.out.println("Report ID: " + id);
        System.out.println("Lecturer ID: " + lecturerId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Report Information: " + reportInfo);
    }
}

