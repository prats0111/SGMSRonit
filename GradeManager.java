import java.util.ArrayList;
import java.util.List;

// Class to manage grades
class GradeManager {
    private List<Grade> grades = new ArrayList<>();

    // Method to add a grade
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    // Method to edit a grade
    public void editGrade(int index, Grade newGrade) {
        if (index >= 0 && index < grades.size()) {
            grades.set(index, newGrade);
        }
    }

    // Method to delete a grade
    public void deleteGrade(int index) {
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
        }
    }

    // Method to get all grades
    public List<Grade> getGrades() {
        return grades;
    }
}
