package com.vmware.CapstoneSearch.Models;

import java.util.Date;

public class Source {

    private boolean adopted;
    private String zip;
    private String sex;

    private String version;
    private String timestamp;
    private String type;
    private String age;
    private Long pet_id;
    private String breed;
    private String name;

    private boolean reported;
    private double weight;
    private String cover_photo;
    private int favorite_count;
    private String owner;
    private boolean reproductive_status;
    private String description;
    private String city;
    private String state;
    private String species;
    private Date date_posted;


    public Source() {
    }


    public Source(boolean adopted, String zip, String sex, String version, String timestamp, String type, String age, Long pet_id, String breed, String name, boolean reported, double weight, String cover_photo, int favorite_count, String owner, boolean reproductive_status, String description, String city, String state, String species, Date date_posted) {
        this.adopted = adopted;
        this.zip = zip;
        this.sex = sex;
        this.version = version;
        this.timestamp = timestamp;
        this.type = type;
        this.age = age;
        this.pet_id = pet_id;
        this.breed = breed;
        this.name = name;
        this.reported = reported;
        this.weight = weight;
        this.cover_photo = cover_photo;
        this.favorite_count = favorite_count;
        this.owner = owner;
        this.reproductive_status = reproductive_status;
        this.description = description;
        this.city = city;
        this.state = state;
        this.species = species;
        this.date_posted = date_posted;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        this.sex = sex;

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

    public Long getPet_id() {
        return pet_id;
    }

    public void setPet_id(Long pet_id) {
        this.pet_id = pet_id;
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

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isReproductive_status() {
        return reproductive_status;
    }

    public void setReproductive_status(boolean reproductive_status) {
        this.reproductive_status = reproductive_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(Date date_posted) {
        this.date_posted = date_posted;
    }

    @Override
    public String toString() {
        return "Source{" +
                "adopted=" + adopted +
                ", zip='" + zip + '\'' +
                ", sex='" + sex + '\'' +
                ", version='" + version + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", pet_id=" + pet_id +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", reported=" + reported +
                ", weight=" + weight +
                ", cover_photo='" + cover_photo + '\'' +
                ", favorite_count=" + favorite_count +
                ", owner='" + owner + '\'' +
                ", reproductive_status=" + reproductive_status +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", species='" + species + '\'' +
                ", date_posted=" + date_posted +
                '}';
    }
}
