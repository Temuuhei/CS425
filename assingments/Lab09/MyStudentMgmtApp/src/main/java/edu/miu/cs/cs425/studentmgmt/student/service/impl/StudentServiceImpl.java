package edu.miu.cs.cs425.studentmgmt.student.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.studentmgmt.student.model.Student;
import edu.miu.cs.cs425.studentmgmt.student.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    // @Autowired -- Not needed for SpringBoot v2+
    // @Autowired
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
   public Student getStudentById(Long studentId){
       return studentRepository.findById(studentId).orElse(null);
   }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
