package com.vmware.CapstoneSearch.Models;

public class Source {

    private boolean adopted;
    private String zip;
    private String gender;
    private String version;
    private String timestamp;
    private String type;
    private String age;
    private long petId;
    private String breed;
    private String name;

    private boolean reported;
    private double weight;
    private String cover_photo;
    private int favorite_count;
    private String owner;
    private boolean reproductive_status;
    private String description;

    public Source() {
    }


    public Source(boolean adopted, String zip, String gender, String version, String timestamp, String type, String age, long petId, String breed, String name, boolean reported, double weight, String cover_photo, int favorite_count, String owner, boolean reproductive_status, String description) {
        this.adopted = adopted;
        this.zip = zip;
        this.gender = gender;
        this.version = version;
        this.timestamp = timestamp;
        this.type = type;
        this.age = age;
        this.petId = petId;
        this.breed = breed;
        this.name = name;
        this.reported = reported;
        this.weight = weight;
        this.cover_photo = cover_photo;
        this.favorite_count = favorite_count;
        this.owner = owner;
        this.reproductive_status = reproductive_status;
        this.description = description;
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

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
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

    @Override
    public String toString() {
        return "Source{" +
                "adopted=" + adopted +
                ", zip='" + zip + '\'' +
                ", gender='" + gender + '\'' +
                ", version='" + version + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", petId=" + petId +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", reported=" + reported +
                ", weight=" + weight +
                ", cover_photo='" + cover_photo + '\'' +
                ", favorite_count=" + favorite_count +
                ", owner='" + owner + '\'' +
                ", reproductive_status='" + reproductive_status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
