package com.vmware.CapstoneSearch;

import com.vmware.CapstoneSearch.Models.Photo;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pets")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    private String owner;
    private String name;
    private String city;
    private String state;
    private String zip;
    private String type;
    private String breed;
    private String species;
    private double weight;
    private String age;

    private String sex;

    private boolean reproductiveStatus;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String coverPhoto;
    private int favoriteCount;
    private boolean reported;
    private boolean adopted;
    @OneToMany(mappedBy = "pet", fetch=FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();
    private float score;
    @Column(name = "date_posted", updatable = false)
    @CreatedDate
    private Date datePosted;

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

    public Pet(Long petId, String owner, String name, String city, String state, String zip, String type, String breed, String species, double weight, String age, String sex, boolean reproductiveStatus, String description, String coverPhoto, int favoriteCount, boolean reported, boolean adopted, List<Photo> photos, float score, Date datePosted) {
        this.petId = petId;
        this.owner = owner;
        this.name = name;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
        this.breed = breed;
        this.species = species;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.reproductiveStatus = reproductiveStatus;
        this.description = description;
        this.coverPhoto = coverPhoto;
        this.favoriteCount = favoriteCount;
        this.reported = reported;
        this.adopted = adopted;
        this.photos = photos;
        this.score = score;
        this.datePosted = datePosted;
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

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", reproductiveStatus=" + reproductiveStatus +
                ", description='" + description + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", favoriteCount=" + favoriteCount +
                ", reported=" + reported +
                ", adopted=" + adopted +
                ", photos=" + photos +
                ", score=" + score +
                ", datePosted=" + datePosted +
                '}';
    }
}
