package model.repo;

import model.entities.Student;
import ultis.GenericRepository;

import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl extends GenericRepository<Student> implements StudentRepository {
    public StudentRepositoryImpl() {
        super(Student.class);
    }

    @Override
    public void add(Student student) {
        super.create(student);
    }

    @Override
    public Optional<Student> getStudenById(int id) {
        Student resulf = super.getById(id);
        if(resulf == null){
            return Optional.empty();
        }
        return Optional.of(resulf);
    }


    @Override
    public List<Student> getAll() {
        return super.getAll();
    }


}
