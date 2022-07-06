package edu.miu.cs.cs425.studentmgmt.student;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import edu.miu.cs.cs425.studentmgmt.student.model.Student;
import edu.miu.cs.cs425.studentmgmt.student.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.student.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.student.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.student.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.student.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.student.service.TranscriptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner{

	// @Autowired
	private StudentService studentService;
	private TranscriptService transcriptService;
	private ClassroomService classRoomService;

	public StudentApplication (StudentService studentService, TranscriptService transcriptService, ClassroomService classRoomService) {
		this.studentService = studentService;
		this.transcriptService = transcriptService;
		this.classRoomService = classRoomService;
	}
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world Spring Boot!!");
		Student temka = new Student( (long) 1,"613754","Temuujin", "T", "Tsogt", 4.0, LocalDate.of(2021,11,01));
		Student temka1 = new Student( (long) 2,"6137542","Temuujin2", "T", "Tsogt", 4.0, LocalDate.of(2020,11,01));
		
		// many2one - students - class
		// one2many class - students
		Classroom class1 = new Classroom(null,"McLaughlin building", "M105");
		createNewClass(class1);
		System.out.println(temka.toString());
		createNewStudent(temka);
		createNewStudent(temka1);

		temka.setClassroom(class1);
		temka1.setClassroom(class1);
		// var testStud = studentService.getStudentById((long) 15);
		// testStud.setClassroom(class1);
		
		
		System.out.println("------ All data -------");
		printAllStudents();
		printStudentById((long) 1);
		printStudentById((long) 10);
		updateAndPrintStudentById((long) 1);
		// deleteStudentById((long) 1);


	}

	private Student createNewStudent(Student student) { //Create
		return studentService.addNewStudent(student);
	}

	private Transcript createNewTranscript(Transcript transcript) { //Create
		return transcriptService.addNewTranscript(transcript);
	}

	private Classroom createNewClass(Classroom classroom) { //Create
		return classRoomService.addNewClass(classroom);
	}

	private List<Student> getStudents(Classroom classroom){
		return classRoomService.getStudents(classroom);
	}

	private void printAllStudents() { //Read
		var students = studentService.getAllStudents();
		students.forEach(System.out::println);
	}

	private void printStudentById(Long studentId) {
		var student = studentService.getStudentById(studentId);
		if(student != null) {
			System.out.println(student);
		} else {
			System.out.printf("Student with StudentId: %s is not found! \n", studentId);
		}
	}

	private void updateAndPrintStudentById(Long studentId) { // Update
		var stud1 = studentService.getStudentById(studentId);
		// Create Transcript and associate to Student
		
		var existeTranscript = transcriptService.getTranscriptById(1);
		if (existeTranscript == null) {
			existeTranscript = new Transcript(null,"Masters in Computer Science", stud1);
		}
		System.out.println(existeTranscript);
		System.out.println(stud1);

		// createNewTranscript(newTranscript);
		stud1.setTranscript(existeTranscript);
		
		var updatedStudent = studentService.updateStudent(stud1);
		System.out.println(updatedStudent);

	}

	private void deleteStudentById(Long studentId) { // delete
		studentService.deleteStudentById(studentId);
	}

}
