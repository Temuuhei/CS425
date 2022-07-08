package erigstrar.eregistrarwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import erigstrar.eregistrarwebapp.model.Student;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository <Student, Integer>{
    // Custom Query using JPQL
    // @Query(value = "select p from estudents p where p.first_name = :first_name")
    // List<Student> getPublisherByName(String first_name);
    @Query(value = "SELECT * FROM estudents t WHERE t.first_name LIKE %?1%", nativeQuery = true)
    List<Student> findByStudentName(String firstName);
}
