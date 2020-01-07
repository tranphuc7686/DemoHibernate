package model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    private int id;
    private String streets;

    public Address(int id, String streets) {
        this.id = id;
        this.streets = streets;
    }
    public Address( String streets) {
        this.streets = streets;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
