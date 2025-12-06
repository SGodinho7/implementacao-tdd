package com.example.implementacao_tdd.dto;

import com.example.implementacao_tdd.entity.Curso;

public class CursoDTO {
	
	private Long id;
	private String titulo;
	private float media;
	private int custo;
	private boolean is_completed;
	
	public CursoDTO() {}
	
	public CursoDTO(long id, String titulo, float media, int custo, boolean is_completed) {
		this.id = id;
		this.titulo = titulo;
		this.media = media;
		this.custo = custo;
		this.is_completed = is_completed;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public float getMedia() {
		return this.media;
	}
	
	public void setMedia(float media) {
		this.media = media;
	}
	
	public int getCusto() {
		return this.custo;
	}
	
	public void setCusto(int custo) {
		this.custo = custo;
	}
	
	public boolean getCompletedStatus() {
		return this.is_completed;
	}
	
	public void setCompletedStatus(boolean status) {
		this.is_completed = status;
	}
	
	public static CursoDTO fromEntity(Curso curso) {
		CursoDTO dto = new CursoDTO();
		if(curso.getId() == null)
			dto.setId(0L);
		else
			dto.setId(curso.getId());
		dto.setTitulo(curso.getTitulo());
		dto.setMedia(curso.getNota());
		dto.setCusto(curso.getCusto());
		dto.setCompletedStatus(curso.getCompletedStatus());
		
		return dto;
	}
}
