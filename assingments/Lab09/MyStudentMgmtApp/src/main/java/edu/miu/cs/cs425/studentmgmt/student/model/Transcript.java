package edu.miu.cs.cs425.studentmgmt.student.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Entity
// @AllArgsConstructor
@NoArgsConstructor
@Table(name="transcript")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transciptId;

    @Column(name="degreeTitle")
    private String degreeTitle;

    @OneToOne(mappedBy = "transcriptId")
    private Student student;


    public Transcript(Integer id, String name, Student stud1) {
        this.transciptId = null;
        this.degreeTitle = name;
        this.student = stud1;
    }


    @Override
    public String toString() {
        return String.format("{ %s, %s}", transciptId, degreeTitle);
    }

}
