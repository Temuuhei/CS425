package erigstrar.eregistrarwebapp.service;

import java.util.List;

import erigstrar.eregistrarwebapp.model.Student;

public interface StudentService  {
    public abstract Student addNewStudent(Student student);
    public abstract List<Student> getAllStudents();
    public abstract List<Student> getAllStudentsByName(String name);

    public abstract Student getStudentById(Integer studentId);

    Student updateStudent(Student updatedStudent);

    void deleteStudentById(Integer studentId);
}
