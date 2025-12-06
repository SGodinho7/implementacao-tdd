package com.example.implementacao_tdd.controller.test;

import com.example.implementacao_tdd.controller.*;
import com.example.implementacao_tdd.dto.*;
import com.example.implementacao_tdd.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoService CursoService;

    @Test
    public void testGetCursos() throws Exception {
        CursoDTO mockCurso = new CursoDTO();
        mockCurso.setId(1L);
        mockCurso.setTitulo("python");
        mockCurso.setMedia(7);
        mockCurso.setCusto(15);
        mockCurso.setCompletedStatus(true);;
        
        List<CursoDTO> mockCursos = List.of(mockCurso);
        Mockito.when(CursoService.getAllCursos()).thenReturn(mockCursos);

        mockMvc.perform(MockMvcRequestBuilders.get("/cursos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].titulo").value("python"))
        		.andExpect(jsonPath("$[0].media").value(7))
        		.andExpect(jsonPath("$[0].custo").value(15))
        		.andExpect(jsonPath("$[0].completedStatus").value(true));
    }
}
