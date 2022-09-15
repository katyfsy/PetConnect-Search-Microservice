package com.vmware.CapstoneSearch;

import com.vmware.CapstoneSearch.Models.Photo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pets")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    private String owner;
    private String name;
    private String zip;
    private String type;
    private String breed;
    private String age;
    private double weight;
    private String sex;

    private boolean reproductiveStatus;
    private String description;
    private String coverPhoto;
    private int favoriteCount;
    private boolean reported;
    private boolean adopted;
    @OneToMany(mappedBy = "pet", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();
    private float score;


    public Pet() {
    }

    public Pet(String name, String zip, String type, String breed, String age, String sex) {
        this.name = name;
        this.zip = zip;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
    }

    public Pet(Long petId, String owner, String name, String zip, String type, String breed, String age, double weight, String sex, boolean reproductiveStatus, String description, String coverPhoto, int favoriteCount, boolean reported, boolean adopted, List<Photo> photos, float score) {
        this.petId = petId;
        this.owner = owner;
        this.name = name;
        this.zip = zip;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        this.sex = sex;
        this.reproductiveStatus = reproductiveStatus;
        this.description = description;
        this.coverPhoto = coverPhoto;
        this.favoriteCount = favoriteCount;
        this.reported = reported;
        this.adopted = adopted;
        this.photos = photos;
        this.score = score;
    }


    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isReproductiveStatus() {
        return reproductiveStatus;
    }

    public void setReproductiveStatus(boolean reproductiveStatus) {
        this.reproductiveStatus = reproductiveStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", zip='" + zip + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' +
                ", weight=" + weight +
                ", sex='" + sex + '\'' +
                ", reproductiveStatus=" + reproductiveStatus +
                ", description='" + description + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", favoriteCount=" + favoriteCount +
                ", reported=" + reported +
                ", adopted=" + adopted +
                ", photos=" + photos +
                ", score=" + score +
                '}';
    }
}
