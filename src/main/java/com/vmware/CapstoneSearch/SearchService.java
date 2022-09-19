package com.vmware.CapstoneSearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vmware.CapstoneSearch.Models.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchService {
    PetsRepository petsRepository;

    public SearchService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public Pet addPet(Pet pet) {
        return petsRepository.save(pet);
    }

    // get pets based on exact matches
    public PetsList getPets(String zip, String radius, String type, String breed, String age, String sex, String search) throws JsonProcessingException {
        List<String> zips = new ArrayList<>();
        if (zip != null) {

//            String uri = "https://www.zipcodeapi.com/rest/DemoOnly00YY1F0X8lhFDeitNw4cjgF5hQWCLen5Yw0p4F2mmkLO7I52V8Da6jd3/radius.json/" + zip + "/" + radius + "/mile";

            String uri = "https://www.zipcodeapi.com/rest/BGqwQp2uy3Ro7ll4fguvUQByCLqVjzr7uyMRy9QEm3NsKh79piR2iEeODxwnKO5d/radius.json/" + zip + "/"+ radius + "/mile";

            RestTemplate restTemplate = new RestTemplate();
            ZipList response = restTemplate.getForObject(uri, ZipList.class);
            for (Zip code : response.getZip_codes()) {
                zips.add(code.zip_code);
            }
        }

        if (search != null) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String query;
            if (search.equals("*")) {
                query = "{\"query\":{\"match_all\":{}}}";
            } else {
                query = "{\"query\":{\"multi_match\":{\"query\":\"" + search + "\",\"type\":\"cross_fields\",\"fields\":[\"breed\",\"age\",\"sex\",\"name\",\"type\"],\"operator\":\"and\"}}}";
            }
            HttpEntity<?> httpEntity = new HttpEntity<String>(query, headers);

            ResponseEntity<SearchResults> response = restTemplate.exchange("http://elasticsearch:9200/pets/_search?pretty", HttpMethod.POST, httpEntity, SearchResults.class);
            List<Hit> hits = response.getBody().getHits().getHits();
//            System.out.println(hits);
            List<Pet> convertedHitstoPets = new ArrayList<>();
            for (int i = 0; i < hits.size(); i++) {
                Source pet = hits.get(i).get_source();
                if (zip != null && zips.contains(pet.getZip())) {
                    convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getWeight(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
                } else if (zip == null) {
                    convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getWeight(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
                }
            }
            List<Pet> filteredPets = convertedHitstoPets;
            if (type != null) {
                filteredPets = filteredPets.stream().filter(pet -> pet.getType().equals(type)).collect(Collectors.toList());
            }
            if (breed != null) {
                filteredPets = filteredPets.stream().filter(pet -> pet.getBreed().equals(breed)).collect(Collectors.toList());
            }
            if (age != null) {
                filteredPets = filteredPets.stream().filter(pet -> pet.getAge().equals(age)).collect(Collectors.toList());
            }
            if (sex != null) {
                filteredPets = filteredPets.stream().filter(pet -> pet.getSex().equals(sex)).collect(Collectors.toList());
            }
            return new PetsList(filteredPets);

        } else {
            List<Pet> results = new ArrayList<>();
            ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
            if (zips.size() > 0) {
                for (int i = 0; i < zips.size(); i++) {
                    Example<Pet> exampleQuery = Example.of(new Pet(null, zips.get(i), type, breed, age, sex), matcher);
                    results.addAll(petsRepository.findAll(exampleQuery));
                }
            } else {
                Example<Pet> exampleQuery = Example.of(new Pet(null, zip, type, breed, age, sex), matcher);
                results.addAll(petsRepository.findAll(exampleQuery));
            }

            return new PetsList(results);
        }
    }

    public List<String> getBreeds(String type) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String query = "{\"query\":{\"match_all\":{}}}";
        HttpEntity<?> httpEntity = new HttpEntity<String>(query, headers);

        ResponseEntity<SearchResults> response = restTemplate.exchange("http://elasticsearch:9200/pets/_search?pretty", HttpMethod.POST, httpEntity, SearchResults.class);
        List<Hit> hits = response.getBody().getHits().getHits();

        List<Pet> convertedHitstoPets = new ArrayList<>();
        for (int i = 0; i < hits.size(); i++) {
            Source pet = hits.get(i).get_source();
            convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getWeight(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
            }
        List<Pet> filteredPets = convertedHitstoPets;
        if (type != null) {
            filteredPets = filteredPets.stream().filter(pet -> pet.getType().equals(type)).collect(Collectors.toList());
        }
        List<Breed> filteredBreeds = new ArrayList<>();
        for (int i = 0; i < filteredPets.size(); i++) {
            filteredBreeds.add(new Breed(filteredPets.get(i).getBreed()));
        }

        Set<String> uniqueBreeds = new HashSet<String>();
        for (int i = 0; i < filteredPets.size(); i++) {
            uniqueBreeds.add(filteredPets.get(i).getBreed());
        }
//        System.out.println("*******filteredbreeds*******" + uniqueBreeds);
        return List.copyOf(uniqueBreeds);
    }

    // gets documents using wildcard query
    public PetsList getSuggestions(String search) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> httpEntity = new HttpEntity<String>("{\"query\":{\"multi_match\":{\"query\":\"" + search + "*\",\"fields\":[\"breed\",\"age\",\"gender\",\"name\",\"type\"],\"fuzziness\":\"2\"}}}", headers);
        ResponseEntity<SearchResults> response = restTemplate.exchange("http://elasticsearch:9200/pets/_search?pretty", HttpMethod.POST, httpEntity, SearchResults.class);

        List<Hit> hits = response.getBody().getHits().getHits();
        System.out.println("hits ===> " + hits);
        List<Pet> convertedHitstoPets = new ArrayList<>();
        for (int i = 0; i < hits.size(); i++) {
            Source pet = hits.get(i).get_source();
            convertedHitstoPets.add(new Pet(pet.getName(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getAge(), pet.getSex()));
            }
        return new PetsList(convertedHitstoPets);
    }

}
