package com.vmware.CapstoneSearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//allowing frontend in from port 3000
@CrossOrigin(origins="http://localhost:3000")
@RestController

public class SearchController {
    SearchService searchService;


    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/api/petSearch")
    public ResponseEntity<PetsList> getPets(@RequestParam(required = false) String zip,  @RequestParam(required = false, defaultValue="10") String radius, @RequestParam(required = false) String type, @RequestParam(required = false) String breed, @RequestParam(required = false) String age, @RequestParam(required = false) String sex, @RequestParam(required = false) String search) throws JsonProcessingException {
        PetsList petsList;
        petsList = searchService.getPets(zip, radius, type, breed, age, sex, search);
        return petsList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(petsList);
    }

    @GetMapping("/api/breeds")
    public ResponseEntity<List> getBreeds(@RequestParam(required = false) String type) {
//        System.out.println("got request");
        List<String> breedList = searchService.getBreeds(type);
        return breedList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(breedList);
    }

    @PostMapping("/api/petSearch")
    public Pet addPet(@RequestBody Pet pet) { return searchService.addPet(pet); }



    // approximate search - returns autocomplete options
    @GetMapping("/api/suggestions")
    public ResponseEntity<PetsList> getSuggestions(@RequestParam(required = false) String search) {
//        System.out.println("got request");
        PetsList petsList = searchService.getSuggestions(search);
        return petsList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(petsList);
    }

}
