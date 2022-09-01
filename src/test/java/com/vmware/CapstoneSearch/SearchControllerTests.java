package com.vmware.CapstoneSearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchController.class)
public class SearchControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SearchService searchService;

    //GET: /api/petSearch returns all pets
    @Test
    void getPets_noParams_exists_returnsPetsList() throws Exception {
        //arrange
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        //act
        when(searchService.getPets(null, null, null, null, null)).thenReturn(new PetsList(pets));
        //assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }

    @Test
    void getPets_zipParam_exists_returnsPetsList() throws Exception {
        //arrange
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        when(searchService.getPets("12345", null, null, null, null)).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?zip=12345"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }

    @Test
    void getPets_typeParam_exists_returnsPetsLists() throws Exception {
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        when(searchService.getPets(null, "dog", null, null, null)).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?type=dog"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }

    @Test
    void getPets_breedParam_exists_returnsPetsList() throws Exception {
        //arrange
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        when(searchService.getPets(null, null, "husky", null, null)).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?breed=husky"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }

    @Test
    void getPets_ageParam_exists_returnsPetsList() throws Exception {
        //arrange
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        when(searchService.getPets(null, null, null, "young", null)).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?age=young"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }

    @Test
    void getPets_genderParam_exists_returnsPetsList() throws Exception {
        //arrange
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        when(searchService.getPets(null, null, null, null, "female")).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?gender=female"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }

    @Test
    void getPets_zipParamAndTypeParam_exists_returnsPetsLists() throws Exception {
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        when(searchService.getPets("12345", "dog", null, null, null)).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?zip=12345&type=dog"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }



}
