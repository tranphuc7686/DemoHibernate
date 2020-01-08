package model.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "teacher")
public class Teacher {
    private Integer id;
    private String name;
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(Integer id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }
    public Teacher(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
    @Id
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
    @OneToMany(mappedBy = "teacher")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
