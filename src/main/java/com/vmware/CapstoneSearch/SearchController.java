package com.vmware.CapstoneSearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//allowing frontend in from port 3000
@CrossOrigin(origins="http://localhost:3000")
@RestController

public class SearchController {
    SearchService searchService;


    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/api/petSearch")
    public ResponseEntity<PetsList> getPets(@RequestParam(required = false) String zip, @RequestParam(required = false) String type, @RequestParam(required = false) String breed, @RequestParam(required = false) String age, @RequestParam(required = false) String gender, @RequestParam(required = false) String search) throws JsonProcessingException {
        PetsList petsList;
        petsList = searchService.getPets(zip, type, breed, age, gender, search);
        return petsList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(petsList);
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
