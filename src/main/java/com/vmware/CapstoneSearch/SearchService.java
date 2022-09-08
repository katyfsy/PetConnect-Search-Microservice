package com.vmware.CapstoneSearch;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchService {
    PetsRepository petsRepository;

    public SearchService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public Pet addPet(Pet pet) {
        return petsRepository.save(pet);
    }

    public PetsList getPets(String zip, String type, String breed, String age, String gender, String search) {
        if (search != null) {
            String uri = "http://localhost:9200/pets/_search?pretty";
            String fields[] = new String[] {"breed", "type", "name"};
            Body body = new Body(new Query(new Match("dog", Arrays.asList(fields))));
            RestTemplate restTemplate = new RestTemplate();
            SearchResults searchResults = restTemplate.getForObject(uri, SearchResults.class, body);
            System.out.println(searchResults);
            return new PetsList();
        } else {
            List<String> zips = new ArrayList<>();
            if (zip != null) {
                String uri = "https://www.zipcodeapi.com/rest/BGqwQp2uy3Ro7ll4fguvUQByCLqVjzr7uyMRy9QEm3NsKh79piR2iEeODxwnKO5d/radius.json/" + zip + "/10/mile";
                RestTemplate restTemplate = new RestTemplate();
                ZipList response = restTemplate.getForObject(uri, ZipList.class);
                for (Zip code : response.getZip_codes()) {
                    zips.add(code.zip_code);
                }
            }

            List<Pet> results = new ArrayList<>();
            ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
            if (zips.size() > 0) {
                for (int i = 0; i < zips.size(); i++) {
                    Example<Pet> exampleQuery = Example.of(new Pet(null, zips.get(i), type, breed, age, gender), matcher);
                    results.addAll(petsRepository.findAll(exampleQuery));
                }
            } else {
                Example<Pet> exampleQuery = Example.of(new Pet(null, zip, type, breed, age, gender), matcher);
                results.addAll(petsRepository.findAll(exampleQuery));
            }


            return new PetsList(results);
        }
    }
}
