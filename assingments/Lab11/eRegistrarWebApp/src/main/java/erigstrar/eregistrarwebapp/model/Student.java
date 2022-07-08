package erigstrar.eregistrarwebapp.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "estudents")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name="student_number", nullable = false)
    @NotBlank(message = "Publisher Name cannot be null or empty or blank spaces")// name="   "
    private String studentNumber;

    @Column(name= "firstName", nullable = false)
    private String firstName;

    @Column(name= "middleName", nullable = true)
    private String middleName;

    @Column(name= "lastName", nullable = false)
    private String lastName;

    @Column(name= "cgpa", nullable = true)
    private Double cgpa;
    
    @Column(name= "enrollmentDate", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @Column(name= "isInternational", nullable = false)
    // @Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private boolean isInternational;

    
    public Student() {}

    public Student(Integer studentId, String firstName, String middleName, String lastName, Double cgpa, LocalDate enroLocalDate, boolean isInternational) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName =lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enroLocalDate;
        this.isInternational = isInternational;
    }

    @Override
    public String toString() {
        return String.format("{StudentId: %d, StudentNumber: %s, FirstName: %s, MiddleName: %s, LastName: %s, cgpa: %s, enrollmentDate: %s, isInternational: %s}\n",
                studentId, studentNumber, firstName, middleName, lastName, cgpa, enrollmentDate, isInternational);
    }



    /**
     * @return Integer return the studentId
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * @return String return the studentNumber
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * @param studentNumber the studentNumber to set
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the cgpa
     */
    public Double getCgpa() {
        return this.cgpa;
    }

    /**
     * @param cgpa the cgpa to set
     */
    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    /**
     * @return LocalDate return the enrollmentDate
     */
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * @param enrollmentDate the enrollmentDate to set
     */
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    /**
     * @return boolean return the isInternational
     */
    public boolean isIsInternational() {
        return isInternational;
    }

    /**
     * @param isInternational the isInternational to set
     */
    public void setIsInternational(boolean isInternational) {
        this.isInternational = isInternational;
    }

}
