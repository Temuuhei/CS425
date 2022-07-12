package etdm.etalentdatamanager.model;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name="athletes")
@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long athleteId;

    @Column(name="ssn", nullable = false, unique = true)
    @NotNull(message = "Ssn Number cannot be null.")
    @NotBlank(message ="Ssn Number cannot be blank")
    private String ssn;

    @Column(name="fullName", nullable = false)
    @NotNull(message = "Product Number cannot be null.")
    private String fullName;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="dateOfBirth", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column(name="dateOfRegistration", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfRegistration;

    @Column(name="totalNumberOfMedalsWon", nullable = false)
    private int totalNumberOfMedalsWon;


    @Column(name="monthSalary", nullable = false)
    private double monthSalary;

    @Column(name = "emailAdress")
    private String emailAdress;




}