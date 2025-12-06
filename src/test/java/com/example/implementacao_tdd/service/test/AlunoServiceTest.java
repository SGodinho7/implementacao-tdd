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

class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAlunos() {
        Aluno aluno1 = new Aluno(1, "Sergio");
        aluno1.setAssinaturaPremium();

        Aluno aluno2 = new Aluno(2, "Eduardo");

        when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno1, aluno2));

        List<AlunoDTO> alunos = alunoService.getAllAlunos();

        assertEquals(2, alunos.size());
        assertEquals("Sergio", alunos.get(0).getName());
        assertEquals("Eduardo", alunos.get(1).getName());
        assertEquals("Premium", alunos.get(0).getAssinatura());
    }
}
