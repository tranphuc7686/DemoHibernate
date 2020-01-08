package model.repo;

import model.entities.Student;
import model.entities.Teacher;
import ultis.GenericRepository;

import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImpl extends GenericRepository<Teacher> implements TeacherRepository {

    public TeacherRepositoryImpl() {
        super(Teacher.class);
    }

    @Override
    public void add(Teacher student) {
        super.create(student);
    }

    @Override
    public void update(Teacher student) {
        super.update(student);
    }

    @Override
    public Optional<Teacher> getTeacherById(int id) {
        Teacher resulf = super.getById(id);
        if(resulf == null){
            return Optional.empty();
        }
        return Optional.of(resulf);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return null;
    }


}
