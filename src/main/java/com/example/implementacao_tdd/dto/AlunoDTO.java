package com.example.implementacao_tdd.dto;

import com.example.implementacao_tdd.entity.Aluno;

public class AlunoDTO {

	private Long id;
	private String name;
	private String assinatura;
	
	public AlunoDTO() {}
	
	public AlunoDTO(long id, String name, String assinatura) {
		this.id = id;
		this.name = name;
		this.assinatura = assinatura;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAssinatura() {
		return this.assinatura;
	}
	
	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}
	
	public static AlunoDTO fromEntity(Aluno aluno) {
		AlunoDTO dto = new AlunoDTO();
		dto.setId(aluno.getId());
		dto.setName(aluno.getName());
		dto.setAssinatura(aluno.getAssinatura());
		
		return dto;
	}
}
