package com.token.services.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.token.services.repository.ChildRepository;
import com.token.services.repository.ParentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FamilyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParentRepository repository;

    @Autowired
    private ChildRepository childRepository;

    private final ObjectMapper om = new ObjectMapper();

    @Test
    void shouldFindAllFatherNames() throws Exception {
        mockMvc.perform(get("/parent/father")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldFindFathersWithMoreThanOneChild() throws Exception {
        mockMvc.perform(get("/parent/father/many-children")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldFindFamilyNames() throws Exception {
        mockMvc.perform(get("/family/names")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shoulCountJohnsChildren() throws Exception {
        mockMvc.perform(get("/parent/father/John")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shoulCountMaryChildren() throws Exception {
        mockMvc.perform(get("/parent/mother/Mary")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
