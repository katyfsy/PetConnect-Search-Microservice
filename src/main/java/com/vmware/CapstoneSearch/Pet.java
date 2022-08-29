package com.vmware.CapstoneSearch;

import javax.persistence.*;

@Entity
@Table(name="pets")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private String zip;

    public Pet() {
    }



    public Pet(String type, String name, String zip) {
        this.type = type;
        this.name = name;
        this.zip = zip;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
