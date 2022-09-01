package com.vmware.CapstoneSearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
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
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "5", "female");
        when(petsRepository.findAll()).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets();
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_ZipArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "5", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets("12345", null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_TypeArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "5", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "dog");
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_ZipArgAndTypeArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "5", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets("12345","dog");
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

}