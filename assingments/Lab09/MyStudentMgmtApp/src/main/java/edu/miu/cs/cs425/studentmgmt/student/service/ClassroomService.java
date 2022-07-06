package edu.miu.cs.cs425.studentmgmt.student.service;

import java.util.List;
import edu.miu.cs.cs425.studentmgmt.student.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.student.model.Student;

public interface ClassroomService {
    
    Classroom addNewClass(Classroom classroom);

    List<Student> getStudents(Classroom classroom);

    public abstract Classroom getClassRoomById(Integer classId);
}
