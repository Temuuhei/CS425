package erigstrar.eregistrarwebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erigstrar.eregistrarwebapp.model.Student;
import erigstrar.eregistrarwebapp.repository.StudentRepository;
import erigstrar.eregistrarwebapp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student addNewStudent(Student student) {
        var newStudent = studentRepository.save(student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        var students = studentRepository.findAll();
        return students;
    }

    @Override
    public List<Student> getAllStudentsByName(String name) {
        var students = studentRepository.findByStudentName(name);
        return students;
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId)
                .orElse(null);
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
