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

    private static String apitoken = "DemoOnly00ys8Rhn3m8HFu5iKNDb7Y7LNj8iDOCTGUwZIx6254s7QVXn42YHzdNR";

    // use to point to deployed be: "http://elasticsearch:9200/pets/_search?pretty&size=1000"
    private static String esInstance = "http://localhost:9200/pets/_search?pretty&size=1000";
    PetsRepository petsRepository;

    public SearchService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public Pet addPet(Pet pet) {
        return petsRepository.save(pet);
    }

    // get pets based on exact matches
    public PetsList getPets(String zip, String radius, String type, String breed, String age, String sex, String search, String adopted) throws JsonProcessingException {
        List<String> zips = new ArrayList<>();
        if (zip != null) {

//            String uri = "https://www.zipcodeapi.com/rest/DemoOnly00YY1F0X8lhFDeitNw4cjgF5hQWCLen5Yw0p4F2mmkLO7I52V8Da6jd3/radius.json/" + zip + "/" + radius + "/mile";

            String uri = "https://www.zipcodeapi.com/rest/" + apitoken + "/radius.json/" + zip + "/"+ radius + "/mile";

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

            ResponseEntity<SearchResults> response = restTemplate.exchange(esInstance, HttpMethod.POST, httpEntity, SearchResults.class);
            List<Hit> hits = response.getBody().getHits().getHits();
//            System.out.println(hits);
            List<Pet> convertedHitstoPets = new ArrayList<>();
            for (int i = 0; i < hits.size(); i++) {
                Source pet = hits.get(i).get_source();
                if (zip != null && zips.contains(pet.getZip())) {
                    convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getSize(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
                } else if (zip == null) {
                    convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getSize(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
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

            boolean adoptedStatus = false;
            if(adopted != null){
                if (adopted.equals("true")) {
                    adoptedStatus = true;
                }
            }

            if (adopted != null) {
                boolean finalAdoptedStatus = adoptedStatus;
                filteredPets = filteredPets.stream().filter(pet -> pet.isAdopted() == finalAdoptedStatus).collect(Collectors.toList());
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

//        String query = "{\"query\":{\"match_all\":{}}}";
//        String query = "{\"query\":{\"match\":{\"type\":{\"query\":\"" + type + "\"}}}}";
        HttpEntity<?> httpEntity = new HttpEntity<String>("{\"query\":{\"match\":{\"type\":{\"query\":\"" + type + "\"}}}}", headers);

        ResponseEntity<SearchResults> response = restTemplate.exchange("http://localhost:9200/pets/_search?pretty&size=1000", HttpMethod.POST, httpEntity, SearchResults.class);
        List<Hit> hits = response.getBody().getHits().getHits();
//        System.out.println("hits *********" + hits);
        List<Pet> convertedHitstoPets = new ArrayList<>();
        for (int i = 0; i < hits.size(); i++) {
            Source pet = hits.get(i).get_source();
            convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getSize(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
            }
//        List<Pet> filteredPets = convertedHitstoPets;
//        if (type.equals("cat") || type.equals("dog")) {
//            filteredPets = filteredPets.stream().filter(pet -> pet.getType().equals(type)).collect(Collectors.toList());
//        }
//        if (type.equals("other")) {
//            filteredPets = filteredPets.stream().filter(pet -> !pet.getType().equals("cat") && !pet.getType().equals("dog")).collect(Collectors.toList());
//        }
//        List<Breed> filteredBreeds = new ArrayList<>();
//        for (int i = 0; i < filteredPets.size(); i++) {
//            filteredBreeds.add(new Breed(filteredPets.get(i).getBreed()));
//        }
//
        Set<String> uniqueBreeds = new HashSet<String>();
        for (int i = 0; i < convertedHitstoPets.size(); i++) {
            uniqueBreeds.add(convertedHitstoPets.get(i).getBreed());
        }
//        System.out.println("*******filteredbreeds*******" + uniqueBreeds);
        return List.copyOf(uniqueBreeds);
    };

    // gets documents using filter (adopted), multi-match, fuzziness and max responses (10) sorted by score
    public PetsList getSuggestions(String search, String zip, String radius) {
        List<String> zips = new ArrayList<>();
        if (zip != null) {

//            String uri = "https://www.zipcodeapi.com/rest/DemoOnly00YY1F0X8lhFDeitNw4cjgF5hQWCLen5Yw0p4F2mmkLO7I52V8Da6jd3/radius.json/" + zip + "/" + radius + "/mile";

            String uri = "https://www.zipcodeapi.com/rest/" + apitoken + "/radius.json/" + zip + "/"+ radius + "/mile";

            RestTemplate restTemplate = new RestTemplate();
            ZipList response = restTemplate.getForObject(uri, ZipList.class);
            for (Zip code : response.getZip_codes()) {
                zips.add(code.zip_code);
            }
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> httpEntity = new HttpEntity<String>("{\"sort\":[{\"@timestamp\":{\"order\":\"asc\",\"format\":\"strict_date_optional_time_nanos\"}},\"_score\"],\"size\":10,\"query\":{\"function_score\":{\"query\":{\"bool\":{\"filter\":{\"term\":{\"adopted\":false}},\"must\":{\"multi_match\":{\"query\":\"" + search + "*\",\"fields\":[\"breed\",\"name\",\"type\",\"description\"],\"fuzziness\":\"2\"}}}},\"script_score\":{\"script\":{\"source\":\"_score\"}}}}}", headers);
        ResponseEntity<SearchResults> response = restTemplate.exchange(esInstance, HttpMethod.POST, httpEntity, SearchResults.class);

        List<Hit> hits = response.getBody().getHits().getHits();


        System.out.println("hits ===> " + hits);
        List<Pet> convertedHitstoPets = new ArrayList<>();
        for (int i = 0; i < hits.size(); i++) {
            Source pet = hits.get(i).get_source();

            if (zip != null && zips.contains(pet.getZip())) {
                convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getSize(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
            } else if (zip == null) {
                convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getSize(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
            }

//                convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getWeight(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
        }
        return new PetsList(convertedHitstoPets);
    }

    public PetsList filterPets(String zip, String radius, String type, String breed, String age, String sex, String search, String adopted) {
        if (type == "*") type = "";
        if (breed == null) breed = "";
        if (age == null) age = "";
        if (sex == null) sex = "";

        List<String> zips = new ArrayList<>();
        if (zip != null) {

//            String uri = "https://www.zipcodeapi.com/rest/DemoOnly00YY1F0X8lhFDeitNw4cjgF5hQWCLen5Yw0p4F2mmkLO7I52V8Da6jd3/radius.json/" + zip + "/" + radius + "/mile";

            String uri = "https://www.zipcodeapi.com/rest/" + apitoken + "/radius.json/" + zip + "/"+ radius + "/mile";

            RestTemplate restTemplate = new RestTemplate();
            ZipList response = restTemplate.getForObject(uri, ZipList.class);
            for (Zip code : response.getZip_codes()) {
                zips.add(code.zip_code);
            }
        }
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String query;
        //main search: only zip
        //adv search: type = other
        //should return: list of all other pets
        System.out.println("BREED " + breed + " | AGE " + age);

        if (search == null && type.equals("other")) {
            query = "{\"query\":{\"bool\":{\"must_not\":[{\"terms\":{\"type\":[\"cat\",\"dog\"]}}]}}}";
            System.out.println("#######CONDITION ONE#######");
            //main search: any string
            //adv search: type = other
        } else if (type.equals("other") && search != null) {
            query = "{\"query\":{\"bool\":{\"must\":[{\"multi_match\":{\"query\":\"" + search + "\",\"fields\":[\"breed\",\"age\",\"gender\",\"name\",\"type\"],\"fuzziness\":\"2\"}}],\"must_not\":[{\"terms\":{\"type\":[\"cat\",\"dog\"]}}]}}}";
            System.out.println("#######CONDITION TWO#######");
        } else if (type.equals("cat") || type.equals("dog")){
            query = "{\"query\":{\"bool\":{\"must\":{\"multi_match\":{\"query\":\"" + search + "\",\"fields\":[\"breed\",\"age\",\"sex\",\"name\",\"type\"],\"fuzziness\":2}},\"filter\":[{\"term\":{\"type\":\"" + type + "\"}},{\"term\":{\"sex\":\"" + sex + "\"}},{\"term\":{\"breed\":\"" + breed + "\"}},{\"term\":{\"age\":\"" + age + "\"}}]}}}";
            System.out.println("#######CONDITION THREE#######");
        } else {
            query = "{\"query\":{\"bool\":{\"must\":{\"multi_match\":{\"query\":\"" + search + "\",\"fields\":[\"breed\",\"age\",\"sex\",\"name\",\"type\"],\"fuzziness\":2}},\"filter\":[{\"bool\":{\"should\":[{\"term\":{\"type\":\"" + type +" \"}},{\"term\":{\"sex\":\""+ sex + "\"}},{\"term\":{\"breed\":\"" + breed + "\"}},{\"term\":{\"age\":\"" + age + "\"}}]}}]}}}";
        }
        HttpEntity<?> httpEntity = new HttpEntity<String>(query, headers);

        ResponseEntity<SearchResults> response = restTemplate.exchange(esInstance, HttpMethod.POST, httpEntity, SearchResults.class);
        List<Hit> hits = response.getBody().getHits().getHits();
//            System.out.println(hits);
        List<Pet> convertedHitstoPets = new ArrayList<>();
        for (int i = 0; i < hits.size(); i++) {
            Source pet = hits.get(i).get_source();
            if (zip != null && zips.contains(pet.getZip())) {
                convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getSize(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
            } else if (zip == null) {
                convertedHitstoPets.add(new Pet(pet.getPet_id(), pet.getOwner(), pet.getName(), pet.getCity(), pet.getState(), pet.getZip(), pet.getType(), pet.getBreed(), pet.getSpecies(), pet.getSize(), pet.getAge(), pet.getSex(), pet.isReproductive_status(), pet.getDescription(), pet.getCover_photo(), pet.getFavorite_count(), pet.isReported(), pet.isAdopted(), new ArrayList<>(), hits.get(i).get_score(), pet.getDate_posted()));
            }
        }
        System.out.println(convertedHitstoPets);
        List<Pet> filteredPets = convertedHitstoPets;
//        if (type.equals("cat") || type.equals("dog")) {
//            filteredPets = filteredPets.stream().filter(pet -> pet.getType().equals(type)).collect(Collectors.toList());
//        }
//        if (breed != null) {
//            filteredPets = filteredPets.stream().filter(pet -> pet.getBreed().equals(breed)).collect(Collectors.toList());
//        }
//        if (age != null) {
//            filteredPets = filteredPets.stream().filter(pet -> pet.getAge().equals(age)).collect(Collectors.toList());
//        }
//        if (sex != null) {
//            filteredPets = filteredPets.stream().filter(pet -> pet.getSex().equals(sex)).collect(Collectors.toList());
//        }

        boolean adoptedStatus = false;
        if(adopted != null){
            if (adopted.equals("true")) {
                adoptedStatus = true;
            }
        }
        if (adopted != null) {
            boolean finalAdoptedStatus = adoptedStatus;
            filteredPets = filteredPets.stream().filter(pet -> pet.isAdopted() == finalAdoptedStatus).collect(Collectors.toList());
        }
        return new PetsList(filteredPets);
    }

}
