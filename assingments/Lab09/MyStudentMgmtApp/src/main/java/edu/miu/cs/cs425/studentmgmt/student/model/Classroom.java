package edu.miu.cs.cs425.studentmgmt.student.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="classroom")
public class Classroom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    @Column(name="buildingName")
    private String name;

    @Column(name="roomNumber")
    private String roomNumber;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    public Classroom(Integer classId, String name, String number) {
        this.classId = null;
        this.name = name;
        this.roomNumber = number;
        this.students = new ArrayList<>();
    }

    

    /**
     * @return Integer return the classId
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the roomNumber
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return List<Student> return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        student.setClassroom(this);
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public String toString() {
        return "{"+classId + ", " + getName() + ", " + getRoomNumber() + "}";
    }

}
