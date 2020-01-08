package model.repo;

import model.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void add(Student student);
    Optional<Student> getStudenById(int id);
    List<Student> getAll();
}
