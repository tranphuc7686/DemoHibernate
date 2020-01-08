import model.entities.Student;
import model.entities.Teacher;
import model.repo.AddressRepository;
import model.repo.ClassRepository;
import model.repo.StudentRepository;
import model.repo.TeacherRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public  class Base{
    @Inject
    AddressRepository addressRepository;
    @Inject
    StudentRepository studentRepository;
    @Inject
    ClassRepository classRepository;
    @Inject
    TeacherRepository teacherRepository;





    public Base(){

    }
    void main(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(studentRepository.getStudenById(3).get());
        Teacher coLe = teacherRepository.getTeacherById(2).get();
        coLe.setStudents(studentList);
        teacherRepository.update(coLe);




    }
}