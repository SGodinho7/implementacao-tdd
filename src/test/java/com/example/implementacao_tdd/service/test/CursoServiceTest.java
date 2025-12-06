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

class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCursos() {
        Curso curso1 = new Curso("python");
        curso1.setCusto(7);

        Curso curso2 = new Curso("golang");
        curso2.setCusto(4);

        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso1, curso2));

        List<CursoDTO> cursos = cursoService.getAllCursos();

        assertEquals(2, cursos.size());
        assertEquals("python", cursos.get(0).getTitulo());
        assertEquals("golang", cursos.get(1).getTitulo());
        assertEquals(7, cursos.get(0).getCusto());
        assertEquals(4, cursos.get(1).getCusto());
    }
}