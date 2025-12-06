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

@WebMvcTest(ContaController.class)
public class ContaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContaService contaService;

    @Test
    public void testGetContas() throws Exception {
        ContaDTO mockConta = new ContaDTO();
        mockConta.setId(1L);
        mockConta.setAlunoId(2);
        mockConta.setSaldo(5);
        mockConta.setSaldoCrypto(3);
        
        List<ContaDTO> mockContas = List.of(mockConta);
        Mockito.when(contaService.getAllContas()).thenReturn(mockContas);

        mockMvc.perform(MockMvcRequestBuilders.get("/contas")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].alunoId").value(2))
                .andExpect(jsonPath("$[0].saldo").value(5))
        		.andExpect(jsonPath("$[0].saldoCrypto").value(3));
    }
}
