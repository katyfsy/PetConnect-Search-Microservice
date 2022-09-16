package com.vmware.CapstoneSearch;

public class Breed {

    private String breed;

    public Breed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "breed=" + breed +
                '}';
    }
}
