package com.example.implementacao_tdd;

public class Curso {
	private String titulo;
	private float media;
	private int custo;
	private boolean is_completed;
	
	public Curso(String titulo) {
		this.titulo = titulo;
		this.media = 0.0f;
		this.custo = 0;
		this.is_completed = false;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public float getNota() {
		return this.media;
	}
	
	public void setNota(float nota1, float nota2) {
		this.media = (nota1 + nota2) / 2;
	}

	public int getCusto() {
		return this.custo;	
	}
	
	public void setCusto(int i) {
		this.custo = i;	
	}

	public void concluir() {
		this.is_completed = true;
	}
	
	public boolean getCompletedStatus() {
		return this.is_completed;
	}
}
