package model.repo;

import model.entities.Class;

import java.util.List;
import java.util.Optional;

public interface ClassRepository {
    void add(Class aClass);
    void updateClass(Class aClass);
    Optional<Class> getClassById(int id);
    List<Class> getAllClass();
}
