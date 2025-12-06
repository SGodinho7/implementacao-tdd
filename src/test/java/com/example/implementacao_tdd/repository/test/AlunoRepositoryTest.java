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
public class AlunoRepositoryTest {
	@Autowired
    private AlunoRepository alunoRepository;

    @Test
    void testSaveAndFindAluno() {
    	Aluno aluno = new Aluno(1, "Sergio");
    	aluno.setAssinaturaPremium();

        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId());

        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        assertTrue(retrievedAluno.isPresent());
        assertEquals("Sergio", retrievedAluno.get().getName());
   }

}

