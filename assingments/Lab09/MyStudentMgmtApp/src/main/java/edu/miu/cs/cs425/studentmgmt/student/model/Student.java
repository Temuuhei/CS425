package edu.miu.cs.cs425.studentmgmt.student.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import net.bytebuddy.asm.Advice.Local;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    
    @Column(name="student_number", nullable=false)
    @NotNull(message="Student number cannot be null")
    @NotEmpty(message="Student number cannot be empty")
    @NotBlank(message="Student number cannot be blank spaces")
    private String studentNumber;
    
    @Column(name="first_name", nullable=false)
    @NotNull(message="Student firstname cannot be null")
    @NotEmpty(message="Student firstname cannot be empty")
    @NotBlank(message="Student firstname cannot be blank spaces")
    private String firstName;
    
    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name", nullable=false)
    @NotNull(message="Student lastname cannot be null")
    @NotEmpty(message="Student lastname cannot be empty")
    @NotBlank(message="Student lastname cannot be blank spaces")
    private String lastName;

    @Column(name="cgpa")
    private Double cgpa;
    
    @Column(name = "enrollment_date")
    private LocalDate dateOfEnrollment;
   
    // one2one
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="transcript_id", nullable = true)
    private Transcript transcriptId;

    // many2one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classId")
    private Classroom classroom;

    public Student(){}
    public Student(Long studentId, String studentNumber,String firstName, String middleName, String lastName, Double cgpa, LocalDate enrollmentDate) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = enrollmentDate;
    }




    public long getStudentId() {
        return studentId;
    }


    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }


    public String getStudentNumber() {
        return studentNumber;
    }


    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Double getCgpa() {
        return cgpa;
    }


    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }


    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }


    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Transcript getTranscript() {
        return this.transcriptId;
    }

    public void setTranscript(Transcript transcript) {
        this.transcriptId = transcript;
    }

    @Override
    public String toString() {
        return "{ studentId:" + studentId + "," + "studentNumber: " + studentNumber + ", " +  
                "firstName: " + firstName + ", " + "middleName: " + middleName + ", LastName: " + lastName + 
                ", cgpa: " + cgpa + ", dateOfEnrollment:" + dateOfEnrollment + " transcript: " + transcriptId + 
                "}";
    }


    /**
     * @return Transcript return the transcriptId
     */
    public Transcript getTranscriptId() {
        return transcriptId;
    }

    /**
     * @param transcriptId the transcriptId to set
     */
    public void setTranscriptId(Transcript transcriptId) {
        this.transcriptId = transcriptId;
    }

    /**
     * @return Classroom return the classroom
     */
    public Classroom getClassroom() {
        return classroom;
    }

    /**
     * @param classroom the classroom to set
     */
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

}
