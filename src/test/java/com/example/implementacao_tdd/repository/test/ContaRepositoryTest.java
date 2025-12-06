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
public class ContaRepositoryTest {
	@Autowired
    private ContaRepository contaRepository;

    @Test
    void testSaveAndFindConta() {
    	Conta conta = new Conta();
    	Aluno aluno = new Aluno(1, "Sergio");
    	conta.setAluno(aluno);

        Conta savedConta = contaRepository.save(conta);
        assertNotNull(savedConta.getAluno());

        Optional<Conta> retrievedConta = contaRepository.findById(savedConta.getId());
        assertTrue(retrievedConta.isPresent());
        assertEquals("Sergio", retrievedConta.get().getAluno().getName());
   }

}