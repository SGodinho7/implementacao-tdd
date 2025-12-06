package com.example.implementacao_tdd.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EntityTest {
	@Test
	void testAdicionaMoedaPremium() {
		Aluno aluno = new Aluno(1, "Sergio");
		Aluno aluno2 = new Aluno(2, "Guilherme");
		Conta conta = new Conta();
		Conta conta2 = new Conta();
		Curso curso = new Curso("curso");
		Curso curso2 = new Curso("curso2");
		Curso curso3 = new Curso("curso3");
		
		aluno.setAssinaturaPremium();
		conta.setAluno(aluno);
		conta.addCurso(curso);
		curso.setNota(8, 8);
		conta.concluiCurso(curso);
		
		conta2.setAluno(aluno2);
		conta2.addCurso(curso2);
		curso2.setNota(8, 8);
		conta2.concluiCurso(curso2);
		conta2.concluiCurso(curso2);
		conta2.concluiCurso(curso3);
		
		assertEquals(3, conta.getSaldo(), "As moedas não foram adicionadas");
		assertEquals(0, conta2.getSaldo(), "As moedas foram adicionadas");
		assertEquals(null, conta.procuraCurso(new Curso("cruso")), "Falha no teste");
	}
	
	@Test
	void testConverteMoedasPremium() {
		Aluno aluno = new Aluno(1, "Sergio");
		Conta conta = new Conta();
		
		aluno.setAssinaturaPremium();
		conta.setAluno(aluno);
		conta.AddMoedas(5);
		conta.convertMoedasToCrypto(5);
		
		assertEquals(5, conta.getSaldoCrypto(), "Não foi convertido");
		assertEquals(0, conta.getSaldo(), "Moedas não foram reduzidas");
	}
	
	@Test
	void testCompraCursoComMoedas() {
		Aluno aluno = new Aluno(1, "Sergio");
		Conta conta = new Conta();
		Curso curso = new Curso("curso");
		
		aluno.setAssinaturaPremium();
		conta.setAluno(aluno);
		conta.AddMoedas(5);
		curso.setCusto(3);
		conta.compraCurso(curso);
		
		assertEquals(2, conta.getSaldo(), "Moedas não foram reduzidas");
		assertEquals(curso, conta.procuraCurso(curso), "Curso não foi adicionada a conta");
	}
	
	@Test
	void testMediaBaixaMoedaConta() {
		Aluno aluno = new Aluno(1, "Sergio");
		Conta conta = new Conta();
		Curso curso = new Curso("curso");
		
		aluno.setAssinaturaPremium();
		conta.setAluno(aluno);
		conta.addCurso(curso);
		curso.setNota(4, 4);
		conta.concluiCurso(curso);
		
		assertEquals(0, conta.getSaldo(), "As moedas foram adicionadas");
	}
}
