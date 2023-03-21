package com.example.proyectoBackendOdontolo.controller;


import com.example.proyectoBackendOdontolo.dto.OdontologoFullDto;
import com.example.proyectoBackendOdontolo.service.OdontologoService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import util.JsonUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)

class OdontologoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OdontologoService oService;

    @Test
    void traerOdontologos() {
    }



    @Test
    void eliminar() {
    }

    @Test
    void registrarOdontologo() throws Exception {

        //Arrange
        OdontologoFullDto fullDto = new OdontologoFullDto("fulana","pepita",125);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/odontologos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.asJsonString(fullDto)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        //Asserts
        Assert.assertFalse( response.getResponse().getContentAsString().isEmpty());

    }

    @Test
    void modificar() {
    }
}