package com.vmware.CapstoneSearch;

import java.util.ArrayList;
import java.util.List;

public class BreedList {

    private List<Breed> breeds;

    public BreedList() {this.breeds = new ArrayList<>();}

    public BreedList(List<Breed> breeds) {
        this.breeds = breeds;
    }

    public boolean isEmpty() {
        return this.breeds.isEmpty();
    }

    public int breedSize() {return breeds.size();}

    public List<Breed> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Breed> breeds) {
        this.breeds = breeds;
    }
}
