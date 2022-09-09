package com.vmware.CapstoneSearch.Models;

public class Source {
    private String zip;
    private String gender;
    private String version;
    private String timestamp;
    private String type;
    private String age;
    private int id;
    private String breed;
    private String name;

    public Source() {
    }

    public Source(String zip, String gender, String version, String timestamp, String type, String age, int id, String breed, String name) {
        this.zip = zip;
        this.gender = gender;
        this.version = version;
        this.timestamp = timestamp;
        this.type = type;
        this.age = age;
        this.id = id;
        this.breed = breed;
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Source{" +
                "zip='" + zip + '\'' +
                ", gender='" + gender + '\'' +
                ", version='" + version + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
