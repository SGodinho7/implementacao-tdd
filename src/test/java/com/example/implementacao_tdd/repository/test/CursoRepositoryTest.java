package com.example.implementacao_tdd.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.implementacao_tdd.entity.*;
import com.example.implementacao_tdd.repository.*;

@ActiveProfiles("test")
@DataJpaTest
public class CursoRepositoryTest {
	@Autowired
    private CursoRepository cursoRepository;

    @Test
    void testSaveAndFindCurso() {
    	Curso curso = new Curso("python");
    	curso.setCusto(15);

        Curso savedCurso = cursoRepository.save(curso);
        assertNotNull(savedCurso.getId());

        Optional<Curso> retrievedCurso = cursoRepository.findById(savedCurso.getId());
        assertTrue(retrievedCurso.isPresent());
        assertEquals("python", retrievedCurso.get().getTitulo());
   }

}