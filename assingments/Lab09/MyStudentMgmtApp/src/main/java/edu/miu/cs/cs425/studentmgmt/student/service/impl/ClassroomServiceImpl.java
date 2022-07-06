package edu.miu.cs.cs425.studentmgmt.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import edu.miu.cs.cs425.studentmgmt.student.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.student.model.Student;
import edu.miu.cs.cs425.studentmgmt.student.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.student.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom addNewClass(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Student> getStudents(Classroom classroom){
        return classroom.getStudents();
    }

    @Override
   public Classroom getClassRoomById(Integer classId){
       return classroomRepository.findById(classId).orElse(null);
   }
}
