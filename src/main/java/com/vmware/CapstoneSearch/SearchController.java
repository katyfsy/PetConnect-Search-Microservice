package com.vmware.CapstoneSearch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {
    SearchService searchService;


    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/api/petSearch")
    public ResponseEntity<PetsList> getPets(@RequestParam(required = false) String zip) {
        PetsList petsList;
        if (zip == null) {
            petsList = searchService.getPets();
        } else {
            petsList = searchService.getPets(zip);
        }

        return petsList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(petsList);
    }

    @PostMapping("/api/petSearch")
    public Pet addPet(@RequestBody Pet pet) { return searchService.addPet(pet); }


}
