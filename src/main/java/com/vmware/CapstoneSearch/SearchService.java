package com.vmware.CapstoneSearch;

import org.springframework.stereotype.Service;

@Service
public class SearchService {
    PetsRepository petsRepository;

    public SearchService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public PetsList getPets() {
        return new PetsList(petsRepository.findAll());
    }

}
