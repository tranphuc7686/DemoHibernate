package model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    private Integer id;
    private String name;
    private Integer gender;
    private Integer idClass;
    private List<Class> classes;
    private Integer idAddress;
    private Address address;
    private Integer idTeacher;
    private Teacher teacher;

    public Student() {
    }
    public Student( String name, Integer gender, Integer idClass, List<Class> classes, Integer idAddress, Address address, Integer idTeacher, Teacher teacher) {
        this.name = name;
        this.gender = gender;
        this.idClass = idClass;
        this.classes = classes;
        this.idAddress = idAddress;
        this.address = address;
        this.idTeacher = idTeacher;
        this.teacher = teacher;
    }
    public Student(Integer id, String name, Integer gender, Integer idClass, List<Class> classes, Integer idAddress, Address address, Integer idTeacher, Teacher teacher) {
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
    @Column(name = "id_class")
    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
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
    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }
    @OneToOne
    @JoinColumn(name = "id_address", insertable=false, updatable=false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Column(name = "id_teacher")
    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }
    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id", insertable=false, updatable=false)
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
