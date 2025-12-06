package com.example.implementacao_tdd.dto;

import java.util.ArrayList;

import com.example.implementacao_tdd.entity.Conta;

public class ContaDTO {

	private Long id;
	private Long alunoId;
	private ArrayList<Long> cursosId;
	private int saldo;
	private int saldo_crypto;
	
	public ContaDTO() {}
	
	public ContaDTO(long id, long alunoId, ArrayList<Long> cursosId, int saldo, int saldo_crypto) {
		this.id = id;
		this.alunoId = alunoId;
		this.cursosId = cursosId;
		this.saldo = saldo;
		this.saldo_crypto = saldo_crypto;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAlunoId() {
		return this.alunoId;
	}
	
	public void setAlunoId(long id) {
		this.alunoId = id;
	}
	
	public ArrayList<Long> getCursosId() {
		return this.cursosId;
	}
	
	public void setCursosId(ArrayList<Long> cursosId) {
		this.cursosId = cursosId;
	}
	
	public int getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public int getSaldoCrypto() {
		return this.saldo_crypto;
	}
	
	public void setSaldoCrypto(int saldo_crypto) {
		this.saldo_crypto = saldo_crypto;
	}
	
	public static ContaDTO fromEntity(Conta conta) {
		ContaDTO dto = new ContaDTO();
		if(conta.getId() == null)
			dto.setId(0L);
		else
			dto.setId(conta.getId());
		dto.setAlunoId(conta.getAluno().getId());
		dto.setSaldo(conta.getSaldo());
		dto.setSaldoCrypto(conta.getSaldoCrypto());
		
		ArrayList<Long> cursosId = new ArrayList<Long>();
		for (int i = 0; i < conta.getCursos().size(); i++) {
			cursosId.add(conta.getCursos().get(i).getId());
		}
		dto.setCursosId(cursosId);
		
		return dto;
	}
}
