package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void createUser() throws Exception {
        String body = "{\"id\": 1, \"name\": \"Larry\", \"age\": 28}";
        mvc.perform(MockMvcRequestBuilders.post("/users/").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isCreated());
    }

    @Test
    public void testGetUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    public void testGetUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/{id}", 1)).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Larry"));
    }

    @Test
    public void testAddUser() throws Exception {
        String body = "{\"id\": 2, \"name\": \"Lucy\", \"age\": 18}";
        mvc.perform(MockMvcRequestBuilders.post("/users/").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isCreated());
    }

    @Test
    public void testUpdateUser() throws Exception {
        String body = "{\"id\": 1, \"name\": \"Larry\", \"age\": 29}";
        mvc.perform(MockMvcRequestBuilders.patch("/users/").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/users/{id}", 1)).andExpect(status().isNoContent());
    }

}
