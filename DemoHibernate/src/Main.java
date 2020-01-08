import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module());
        Base base = injector.getInstance(Base.class);
        base.main();


    }

}
