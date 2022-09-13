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
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10", null, null, null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_ZipArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets("12345", "10", null, null, null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_TypeArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10", "dog", null, null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_BreedArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10", null, "husky", null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_AgeArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10", null, null, "young", null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_GenderArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10", null, null, null, "female");
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_ZipArgAndTypeArg_returnsList() {
        Pet pet = new Pet("dog", "lucky", "1234", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets("12345", "10", "dog", null, null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

}