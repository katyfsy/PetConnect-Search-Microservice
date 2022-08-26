package com.vmware.CapstoneSearch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/api/petSearch")
    public ResponseEntity<PetsList> getPets() {
        PetsList petsList = searchService.getPets();
        return petsList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(petsList);
    }


}
