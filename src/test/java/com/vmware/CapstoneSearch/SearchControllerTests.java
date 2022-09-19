package com.vmware.CapstoneSearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
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
    ObjectMapper mapper = new ObjectMapper();

    //GET: /api/petSearch returns all pets
    @Test
    void getPets_noParams_exists_returnsPetsList() throws Exception {
        //arrange
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        //act
        when(searchService.getPets(null, "10",null, null, null, null, null)).thenReturn(new PetsList(pets));
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
        when(searchService.getPets("12345", "10",null, null, null, null, null)).thenReturn(new PetsList(pets));
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
        when(searchService.getPets(null, "10","dog", null, null, null, null)).thenReturn(new PetsList(pets));
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
        when(searchService.getPets(null, "10",null, "husky", null, null, null)).thenReturn(new PetsList(pets));
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
        when(searchService.getPets(null, "10", null, null, "young", null, null)).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?age=young"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }

    @Test
    void getPets_sexParam_exists_returnsPetsList() throws Exception {
        //arrange
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        when(searchService.getPets(null, "10",null, null, null, "female", null)).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?sex=female"))
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
        when(searchService.getPets("12345", "10","dog", null, null, null, null)).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?zip=12345&type=dog"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }

    @Test
    void getPets_SearchParam_exists_returnsPetsLists() throws Exception {
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
        }
        when(searchService.getPets(null, "10",null, null, null, null, "dog")).thenReturn(new PetsList(pets));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?search=dog"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }


    @Test
    void postPets_valid_returnsPet() throws Exception {
        Pet pet = new Pet("Charles", "99111", "iguana", "fire dragon", "adult", "male");
        when(searchService.addPet(any(Pet.class))).thenReturn(pet);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/petSearch")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(pet)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("type").value("iguana"));
    }

  // searching one char at a time - generates autocomplete options
  @Test
  void getSuggestions_oneChar_exists_returnsPetsListThatApproximateSearchQuery() throws Exception {
      //arrange
      List<Pet> pets = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
          pets.add(new Pet("lucky", "1234"+i, "dog", "husky", "young", "female"));
      }
      //act
      when(searchService.getSuggestions("l")).thenReturn(new PetsList(pets));
      //assert
      mockMvc.perform(MockMvcRequestBuilders.get("/api/suggestions?search=l"))
              .andDo(print())
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.pets", hasSize(5)));
  }

//    @Test
//    void getBreeds_typeParam_exists_returnsBreedList() throws Exception {
//        List<String> breeds = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            breeds.add("husky");
//        }
//        when(searchService.getBreeds("dog")).thenReturn(breeds);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/breeds?type=dog"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.breeds", hasSize(5)));
//    }
//
//    @Test
//    void getBreeds_noParam_returnsBreedList() throws Exception {
//        List<String> breeds = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            breeds.add("husky");
//        }
//        when(searchService.getBreeds(null)).thenReturn(breeds);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/breeds"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.breeds", hasSize(5)));
//    }


}
