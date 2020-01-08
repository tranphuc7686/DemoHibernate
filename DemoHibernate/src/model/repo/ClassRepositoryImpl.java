package model.repo;

import model.entities.Class;
import ultis.GenericRepository;

import java.util.List;
import java.util.Optional;

public class ClassRepositoryImpl extends GenericRepository<Class> implements ClassRepository {
    public ClassRepositoryImpl() {
        super(Class.class);
    }

    @Override
    public void add(Class aClass) {
        super.create(aClass);
    }

    @Override
    public void updateClass(Class aClass) {
        super.update(aClass);
    }

    @Override
    public Optional<Class> getClassById(int id) {
        return Optional.of(super.getById(id));
    }

    @Override
    public List<Class> getAllClass() {
        return super.getAll();
    }
}
