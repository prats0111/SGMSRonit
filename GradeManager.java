import java.io.*;
import java.util.*;

public class GradeManager {
    private Map<String, List<Grade>> studentGrades = new HashMap<>();
    private static final String FILE_PATH = "grades.csv";

    public GradeManager() {
        loadGrades();
    }

    public void addGrade(Grade grade, String studentName) {
        List<Grade> grades = studentGrades.getOrDefault(studentName, new ArrayList<>());
        boolean exists = grades.stream().anyMatch(g -> g.subject.equals(grade.subject));
        
        if (!exists) {
            grades.add(grade);
            studentGrades.put(studentName, grades);
            saveGrades(); // Save after adding a grade
        } else {
            System.out.println("Grade for " + studentName + " in " + grade.subject + " already exists.");
        }
    }

    public List<Grade> getGrades(String studentName) {
        return studentGrades.getOrDefault(studentName, new ArrayList<>());
    }

    public Grade getGrade(String studentName, String subject) {
        List<Grade> grades = getGrades(studentName);
        for (Grade grade : grades) {
            if (grade.subject.equals(subject)) {
                return grade;
            }
        }
        return null; // Handle if no grade found
    }

    public Set<String> getAllStudents() {
        return studentGrades.keySet();
    }

    public void deleteGrade(String studentName, String subject) {
        List<Grade> grades = studentGrades.get(studentName);
        if (grades != null) {
            grades.removeIf(grade -> grade.subject.equals(subject));
            saveGrades(); // Save after deleting a grade
        }
    }

    private void loadGrades() {
        studentGrades.clear(); // Clear existing data to avoid duplicates
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean isFirstLine = true; // To skip header if needed
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header line
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String student = parts[0].trim();
                    String subject = parts[1].trim();
                    try {
                        int marks = Integer.parseInt(parts[2].trim()); // Trim to avoid leading/trailing spaces
                        String grade = parts[3].trim(); // Trim spaces
                        addGrade(new Grade(subject, marks, grade), student);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid marks format for student: " + student + ", subject: " + subject);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveGrades() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String student : studentGrades.keySet()) {
                for (Grade grade : studentGrades.get(student)) {
                    bw.write(student + "," + grade.subject + "," + grade.marks + "," + grade.grade);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
