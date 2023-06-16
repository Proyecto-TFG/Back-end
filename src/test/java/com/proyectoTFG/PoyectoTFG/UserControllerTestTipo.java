package com.proyectoTFG.PoyectoTFG;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoTFG.PoyectoTFG.controllers.UsuarioController;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Base64;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestTipo {

    private String token;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Get User Type Test")
    @Test
    public void authenticateTest() throws Exception {
        String userCredentials = "{\"email\": \"gian@mail.com\", \"password\": \"123789654\"}";

        MvcResult result = mockMvc.perform(post("/auth/login")
                .content(userCredentials)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonResponse);
        String token = jsonNode.get("accessToken").asText();

        System.out.println("token antes agregar manualmento rol"+token);
        
        this.token = token;
    }

    @Test
    public void getUserTypeTest() throws Exception {

        if (this.token == null) {
            authenticateTest();
        }

        System.out.println("Token: " + token);

        mockMvc.perform(get("/api/usuarios/tipo")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty());
    }

}
