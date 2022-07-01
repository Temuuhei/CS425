package com.example.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.Student;

import java.time.Period;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class UniversityApplication {

	// 5.3
	public static void printListOfStudents(List<Student> Students) {
		List<Student> sortedStudents = Students.stream()
			.sorted(Comparator.comparing(Student::getName))
			.collect(Collectors.toList());
			for(int i=0; i < Students.size(); i++) {
				System.out.println(Students.get(i).toString());
			};
			System.out.println(" ------ Sorted ------ by ");
			for(int i=0; i < sortedStudents.size(); i++) {
					System.out.println(sortedStudents.get(i).toString());
				};	
    }

	// 5.4
	public static List<Student> getListOfPlatinumAlumniStudents(List<Student> Students) {
		List<Student> sortedPlatinumStudents = Students.stream()
			.filter(stud -> (Period.between(stud.getDateofAdmission(), java.time.LocalDate.now())).getYears() >= 30)
			.sorted(Comparator.comparing(Student::getDateofAdmission).reversed())
			.collect(Collectors.toList());
		return sortedPlatinumStudents;
	}

	// 5.5.1
	public static void printHelloWorld(int[] arr){
		for(int i=0; i < arr.length; i++) {
			if(arr[i] % 5 == 0 && arr[i] % 7 != 0) {
				System.out.println("Hello");
			} else if (arr[i] % 7 == 0 && arr[i] % 5 != 0) {
				System.out.println("World");
			} else if(arr[i] % 35 == 0) {
				System.out.println("HelloWorld");
			}
		}	
	}

	// 5.5.2

	public static int findSecondBiggest(int[] arr) {
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if (firstMax < arr[i]) {
				firstMax = arr[i];
			}
		}
		for(int i = 0; i < arr.length; i++) {
			if (secondMax < arr[i] && firstMax != arr[i]) {
				secondMax = arr[i];
			}
		}
		return secondMax;
	}

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
		List<Student> studentArr = new ArrayList<Student>();


        studentArr.add(new Student(110001, "Dave", LocalDate.of(1951, 11, 18)));
        studentArr.add(new Student(110002, "Anna", LocalDate.of(1990, 12, 07)));
        studentArr.add(new Student(110003, "Erica", LocalDate.of(1974, 01, 31)));
		studentArr.add(new Student(110004, "Carlos", LocalDate.of(2009,8,22)));
		studentArr.add(new Student(110005, "Bob", LocalDate.of(1990,05,03)));
        printListOfStudents(studentArr);
		List<Student> PlatinumAlumni  = getListOfPlatinumAlumniStudents(studentArr);
		System.out.println("--- PlatinumAlumni ---- Sort By dateOfAdmission descending");
		for (Student student : PlatinumAlumni) {
			System.out.println(student.toString());
		};

		// 5.5.1
		int[] arr = {1,2,3,5,7,30,35};
		// 5.5.2
		int[] arr1 = {55, 10, 60, 14, 21, 35};
		printHelloWorld(arr);
		System.out.printf("[1,2,3,5,7,30,35] --> Second max = %s",findSecondBiggest(arr));
		System.out.println("");
		System.out.printf("[55, 10, 60, 14, 21, 35] --> Second max = %s",findSecondBiggest(arr1));
	}

}
