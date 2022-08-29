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

import static org.hamcrest.Matchers.hasSize;
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
            pets.add(new Pet("dog", "lucky"+i, "1234"));
        }
//        PetsList petsList = new PetsList(pets);
        //act
        when(searchService.getPets()).thenReturn(new PetsList(pets));
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
            pets.add(new Pet("dog", "lucky"+i, "1234"));
        }
        //act
        when(searchService.getPets()).thenReturn(new PetsList(pets));
        //assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/petSearch?zip=23415"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pets", hasSize(5)));
    }



}
