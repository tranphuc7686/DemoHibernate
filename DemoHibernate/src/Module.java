import com.google.inject.AbstractModule;
import model.repo.*;

public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(AddressRepository.class).to(AddressRepositoryImpl.class);
        bind(StudentRepository.class).to(StudentRepositoryImpl.class);
        bind(ClassRepository.class).to(ClassRepositoryImpl.class);
        bind(TeacherRepository.class).to(TeacherRepositoryImpl.class);
    }
}
