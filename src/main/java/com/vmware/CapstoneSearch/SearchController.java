package com.vmware.CapstoneSearch;

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
    public ResponseEntity<PetsList> getPets(@RequestParam(required = false) String zip, @RequestParam(required = false) String type, @RequestParam(required = false) String breed) {
        PetsList petsList;
//        if (zip != null && type != null && breed != null) {
//            petsList = searchService.getPets(zip, type);
//        }
//        else if (zip == null && type != null) {
//            petsList = searchService.getPetsByType(type);
//        }
//        else if (type == null && zip != null){
//            petsList = searchService.getPets(zip);
//        } else {
//            petsList = searchService.getPets();
//        }
        petsList = searchService.getPets(zip, type);
        return petsList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(petsList);
    }

    @PostMapping("/api/petSearch")
    public Pet addPet(@RequestBody Pet pet) { return searchService.addPet(pet); }


}
