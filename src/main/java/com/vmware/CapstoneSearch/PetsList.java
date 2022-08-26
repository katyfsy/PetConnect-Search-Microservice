package com.vmware.CapstoneSearch;

import java.util.ArrayList;
import java.util.List;

public class PetsList {

    private List<Pet> pets;

    public PetsList() {
        this.pets = new ArrayList<>();
    }

    public PetsList(List<Pet> pets) {
        this.pets = pets;
    }

    public boolean isEmpty() {
        return this.pets.isEmpty();
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
