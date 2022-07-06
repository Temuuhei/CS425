package edu.miu.cs.cs425.studentmgmt.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.studentmgmt.student.model.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer>{
    
}
