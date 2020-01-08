package model.entities;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    private Integer id;
    private String streets;

    public Address(int id, String streets) {
        this.id = id;
        this.streets = streets;
    }
    public Address( String streets) {
        this.streets = streets;
    }

    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "streets")
    public String getStreets() {
        return streets;
    }

    public void setStreets(String streets) {
        this.streets = streets;
    }
}
