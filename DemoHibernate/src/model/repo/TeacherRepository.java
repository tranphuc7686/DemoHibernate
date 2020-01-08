package model.repo;

import model.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {
    void add(Teacher student);
    void update(Teacher student);
    Optional<Teacher> getTeacherById(int id);
    List<Teacher> getAllTeacher();
}
