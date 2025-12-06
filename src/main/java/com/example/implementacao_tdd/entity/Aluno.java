package com.example.implementacao_tdd.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String assinatura;
	
	public Aluno() {}
	
	public Aluno(long id, String name) {
		this.id = id;
		this.name = name;
		this.assinatura = "Basica";
	}
	
	public Long getId() {
        return id;
    }
	
	public String getName() {
		return this.name;
	}
	
	public String getAssinatura() {
		return this.assinatura;
	}

	public void setAssinaturaPremium() {
		this.assinatura = "Premium";
	}
	
	public boolean isAlunoPremium() {
		return this.assinatura.equals("Premium");
	}

}
