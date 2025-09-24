package com.example.implementacao_tdd;

import java.util.ArrayList;

public class Conta {
	private Aluno aluno;
	private ArrayList<Curso> cursos;
	private int saldo;
	private int saldo_crypto;
	
	public Conta() {
		this.cursos = new ArrayList<Curso>();
		this.saldo = 0;
		this.saldo_crypto = 0;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}

	public void concluiCurso(Curso curso) {
		for (Curso c : this.cursos) {
			if(c.getTitulo().equals(curso.getTitulo()) && !c.getCompletedStatus()) {
				c.concluir();
				if (this.aluno.isAlunoPremium() && c.getNota() >= 7) {
					this.AddMoedas(3);
					return;
				}
			}
		}
	}

	public int getSaldo() {
		return this.saldo;
	}

	public void AddMoedas(int i) {
		this.saldo += i;
	}

	public void convertMoedasToCrypto(int i) {
		this.saldo -= i;
		this.saldo_crypto += i;
	}

	public int getSaldoCrypto() {
		return this.saldo_crypto;
	}

	public void compraCurso(Curso curso) {
		this.saldo -= curso.getCusto();
		this.addCurso(curso);
	}

	public Object procuraCurso(Curso curso) {
		for (Curso c : this.cursos) {
			if(c.getTitulo().equals(curso.getTitulo())) {
				return c;
			}
		}
		return null;
	}

}
