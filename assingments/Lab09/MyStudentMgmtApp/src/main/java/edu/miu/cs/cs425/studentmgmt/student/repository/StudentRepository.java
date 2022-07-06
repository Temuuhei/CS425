package edu.miu.cs.cs425.studentmgmt.student.repository;

import edu.miu.cs.cs425.studentmgmt.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom Query using JPQL
    // @Query(value = "select s from students s where s.first_name = :first_name")
    // Optional<Student> getStudentByName(String first_name);
}
