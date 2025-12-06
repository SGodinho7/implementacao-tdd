package com.example.implementacao_tdd.service.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.implementacao_tdd.dto.*;
import com.example.implementacao_tdd.entity.*;
import com.example.implementacao_tdd.service.*;
import com.example.implementacao_tdd.repository.*;

class ContaServiceTest {

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private ContaService contaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllContas() {
        Conta conta1 = new Conta();
        Aluno aluno1 = new Aluno(1, "Sergio");
        conta1.setAluno(aluno1);
        conta1.AddMoedas(7);
        
        Conta conta2 = new Conta();
        Aluno aluno2 = new Aluno(2, "Eduardo");
        conta2.setAluno(aluno2);
        conta2.AddMoedas(14);

        when(contaRepository.findAll()).thenReturn(Arrays.asList(conta1, conta2));

        List<ContaDTO> contas = contaService.getAllContas();

        assertEquals(2, contas.size());
        assertEquals(1, contas.get(0).getAlunoId());
        assertEquals(2, contas.get(1).getAlunoId());
        assertEquals(7, contas.get(0).getSaldo());
        assertEquals(14, contas.get(1).getSaldo());
    }
}