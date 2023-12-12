package services;

import entites.Report;  // Import your specific class
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportService implements Service<Report> {
    private final File file = new File("data\\reports.txt");
    private static final ArrayList<Report> reports = new ArrayList<>();
    public ReportService() {
        loadDataFromFile();
    }
    @Override
    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Report report : reports) {
                // Customize this line based on the attributes of your Report class
                writer.println(report.getId() + ", " + report.getLecturerId() + ", " +
                        report.getStudentId() + ", " + report.getReportInfo());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(Report report) {
        // Generate ID automatically
        Report lastReport = reports.get(reports.size() - 1);
        report.setId(lastReport.getId() + 1);

        // Implement insert logic here
        reports.add(report);
        saveDataToFile();
    }

    @Override
    public ArrayList<Report> find() {
        return new ArrayList<>(reports);
    }

    @Override
    public void delete(Report report) {
        reports.remove(report);
        saveDataToFile();
    }

    @Override
    public void update(Report report) {
        // Implement update logic here
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).getId() == report.getId()) {
                reports.set(i, report);
                saveDataToFile();
                return;
            }
        }
    }

    private void loadDataFromFile() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                // Customize this section based on the attributes of your Report class
                String[] reportData = scanner.nextLine().split(", ");
                int id = Integer.parseInt(reportData[0]);
                int lecturerId = Integer.parseInt(reportData[1]);
                int studentId = Integer.parseInt(reportData[2]);
                String reportInfo = reportData[3];

                Report report = new Report(id, lecturerId, studentId, reportInfo);
                reports.add(report);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
