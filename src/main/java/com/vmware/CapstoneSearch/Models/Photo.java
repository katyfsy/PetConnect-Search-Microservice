package com.vmware.CapstoneSearch.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vmware.CapstoneSearch.Pet;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "pets_photos", indexes = {@Index(columnList = "pet_id")})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Photo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;
    //    private Long petId;
    private String photo_url;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="pet_id", nullable = false)
    @JsonIgnore
    private Pet pet;

    public Photo() {
    }

    public Photo(Pet pet, String photo_url) {
        this.pet = pet;
        this.photo_url = photo_url;
    }

    public Long getPhotoId() {
        return photoId;
    }

    // DO NOT USE THIS OUTSIDE OF TESTING ENVIRONMENT!!!!!!
    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }
    // READ COMMENT ABOVE!!!!!!!!

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
//                ", petId=" + petId +
                ", photo_url='" + photo_url + '\'' +
                '}';
    }
}


