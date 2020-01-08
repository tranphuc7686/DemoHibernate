package model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {

    private Integer id;
    private Integer total;
    private String name;
    private List<Student> students;

    public Class(Integer total, String name, List<Student> students) {
        this.total = total;
        this.name = name;
        this.students = students;
    }

    public Class() {
    }

    @ManyToMany(fetch=FetchType.EAGER)
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "total")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

}
