package com.example.implementacao_tdd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.implementacao_tdd.repository.*;
import com.example.implementacao_tdd.entity.*;
import com.example.implementacao_tdd.dto.*;

@Service
public class ContaService {

	@Autowired
	private ContaRepository conta_repository;
	
	public List<ContaDTO> getAllContas() {
		List<Conta> contas = this.conta_repository.findAll();
		return contas.stream().map(ContaDTO::fromEntity).collect(Collectors.toList());
	}
}
	
