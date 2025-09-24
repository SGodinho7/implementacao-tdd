package com.example.implementacao_tdd;

public class Aluno {
	private String assinatura;
	
	public Aluno() {
		this.assinatura = "Basica";
	}

	public void setAssinaturaPremium() {
		this.assinatura = "Premium";
	}
	
	public boolean isAlunoPremium() {
		return this.assinatura.equals("Premium");
	}

}
