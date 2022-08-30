package com.vmware.CapstoneSearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {
    PetsRepository petsRepository;

    public SearchService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public PetsList getPets() {
        return new PetsList(petsRepository.findAll());
    }

    public PetsList getPets(String zip) {
        String uri = "https://www.zipcodeapi.com/rest/BGqwQp2uy3Ro7ll4fguvUQByCLqVjzr7uyMRy9QEm3NsKh79piR2iEeODxwnKO5d/radius.json/" + zip + "/10/mile";
        RestTemplate restTemplate = new RestTemplate();
        ZipList response = restTemplate.getForObject(uri, ZipList.class);
        List<String> zips = new ArrayList<>();
        for (Zip code : response.getZip_codes()) {
            zips.add(code.zip_code);
        }
        return new PetsList(petsRepository.findByZipIn(zips));
    }

    public Pet addPet(Pet pet) {
        return petsRepository.save(pet);
    }

    public PetsList getPetsByType(String type) {
        return new PetsList(petsRepository.findByType(type));
    }
}
