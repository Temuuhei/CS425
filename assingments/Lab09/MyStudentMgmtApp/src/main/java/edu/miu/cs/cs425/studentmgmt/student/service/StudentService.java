package edu.miu.cs.cs425.studentmgmt.student.service;

import java.util.List;
import edu.miu.cs.cs425.studentmgmt.student.model.Student;


public interface StudentService {

    public abstract Student addNewStudent(Student student);
    public abstract List<Student> getAllStudents();

    public abstract Student getStudentById(Long studentId);

    Student updateStudent(Student updatedStudent);

    void deleteStudentById(Long studentId);
}
