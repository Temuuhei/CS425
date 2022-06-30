package model;
import java.time.LocalDate;

public class Student {
    private int studentId;
    private String name;
    private LocalDate dateOfAdmission;

    public Student(int studentId, String name, LocalDate dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }


    public int getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDateofAdmission() {
        return this.dateOfAdmission;
    }

    public void setStudentId(int newId) {
        this.studentId = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDateOfAdmission(LocalDate newDate) {
        this.dateOfAdmission = newDate;
    }

    public String toString() {
        return "StudentId: " + getStudentId() + ", name: " + getName() + ", dateOfAdmission: " + getDateofAdmission();
    }

}
