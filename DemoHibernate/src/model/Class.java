package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {

    private int id;
    private int total;
    private String name;
    private List<Student> students;

    public Class(int total, String name, List<Student> students) {
        this.total = total;
        this.name = name;
        this.students = students;
    }

    @ManyToMany
    @JoinTable(name = "classes_students",
        joinColumns = {@JoinColumn(name = "class_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")}

    )
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    @Column(name = "total")
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
