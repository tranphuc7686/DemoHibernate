import model.Address;
import model.Class;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Address nhaPhuc = new Address("TT HUẾ");

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Phúc",1,nhaPhuc,));
        Class aClass = new Class(20,"Hóa Học",students);
        Teacher coLe = new Teacher();
    }
}
