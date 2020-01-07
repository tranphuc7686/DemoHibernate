package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    private int id;
    private String name;
    private int gender;
    private int idClass;
    private List<Class> classes;
    private int idAddress;
    private Address address;
    private int idTeacher;
    private Teacher teacher;

    public Student() {
    }
    public Student( String name, int gender, int idClass, List<Class> classes, int idAddress, Address address, int idTeacher, Teacher teacher) {
        this.name = name;
        this.gender = gender;
        this.idClass = idClass;
        this.classes = classes;
        this.idAddress = idAddress;
        this.address = address;
        this.idTeacher = idTeacher;
        this.teacher = teacher;
    }
    public Student(int id, String name, int gender, int idClass, List<Class> classes, int idAddress, Address address, int idTeacher, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.idClass = idClass;
        this.classes = classes;
        this.idAddress = idAddress;
        this.address = address;
        this.idTeacher = idTeacher;
        this.teacher = teacher;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "gender")
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    @Column(name = "id_class")
    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }
    @ManyToMany
    @JoinTable(name = "classes_students",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}

    )
    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
    @Column(name = "id_address")
    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }
    @OneToOne
    @JoinColumn(name = "id_address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Column(name = "id_teacher")
    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }
    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
