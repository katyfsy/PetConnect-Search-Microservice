package com.vmware.CapstoneSearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.Example;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SearchServiceTest {
    private SearchService searchService;

    @Mock
    PetsRepository petsRepository;

    @BeforeEach
    void setUp() {
        searchService = new SearchService(petsRepository);
    }

    @Test
    void getPets_noArgs_returnsList() throws JsonProcessingException {
        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10",null, null, null, null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

//    @Test
//    void getPets_ZipArg_returnsList() throws JsonProcessingException {
//        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
//        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
//        PetsList petsList = searchService.getPets("12345", null, null, null, null, null);
//        assertThat(petsList).isNotNull();
//        assertThat(petsList.isEmpty()).isFalse();
//    }

    @Test
    void getPets_TypeArg_returnsList() throws JsonProcessingException {
        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10","dog", null, null, null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_BreedArg_returnsList() throws JsonProcessingException {
        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10",null, "husky", null, null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_AgeArg_returnsList() throws JsonProcessingException {
        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10",null, null, "young", null, null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

    @Test
    void getPets_GenderArg_returnsList() throws JsonProcessingException {
        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
        PetsList petsList = searchService.getPets(null, "10",null, null, null, "female", null);
        assertThat(petsList).isNotNull();
        assertThat(petsList.isEmpty()).isFalse();
    }

//    @Test
//    void getPets_ZipArgAndTypeArg_returnsList() throws JsonProcessingException {
//        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
//        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
//        PetsList petsList = searchService.getPets("12345", "dog", null, null, null, null);
//        assertThat(petsList).isNotNull();
//        assertThat(petsList.isEmpty()).isFalse();
//    }

//    @Test
//    void getPets_SearchArg_returnsList() {
//        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
//        when(petsRepository.findAll(any(Example.class))).thenReturn(Arrays.asList(pet));
//        PetsList petsList = searchService.getPets(null, null, null, null, null, "dog");
//        assertThat(petsList).isNotNull();
//        assertThat(petsList.isEmpty()).isFalse();
//    }

    @Test
    void addPet_valid_returnsPet(){
        Pet pet = new Pet("Charles", "91111", "iguana", "fire dragon", "young", "male");
        when(petsRepository.save(any(Pet.class)))
                .thenReturn(pet);
        Pet newPet = searchService.addPet(pet);
        assertThat(newPet).isNotNull();
        assertThat(newPet.getType()).isEqualTo("iguana");
    }

//    @Test
//    void getSuggestions_SearchArg_returnsList() {
////        Pet pet = new Pet("Lucky", "92114", "dog", "husky", "young", "female");
////        when(petsRepository.findAll()).thenReturn(List.of(pet));
//        PetsList petsList = searchService.getSuggestions("d");
//        assertThat(petsList).isNotNull();
//        assertThat(petsList.isEmpty()).isFalse();
//    }


}