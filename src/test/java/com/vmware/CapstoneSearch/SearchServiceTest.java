package com.vmware.CapstoneSearch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {
    private SearchService searchService;

    @Mock
    PetsRepository petsRepository;

    @BeforeEach
    void setUp() {
        searchService = new SearchService(petsRepository);
    }

    @Test
    void getPets_noArgs_returnsList() {
        Pet pet = new Pet("dog", "jim");
        when(petsRepository.findAll()).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets();
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }
}