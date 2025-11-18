package com.example.implementacao_tdd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.implementacao_tdd.repository.*;
import com.example.implementacao_tdd.entity.*;
import com.example.implementacao_tdd.dto.*;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository aluno_repository;
	
	public List<AlunoDTO> getAllAlunos() {
		List<Aluno> alunos = this.aluno_repository.findAll();
		return alunos.stream().map(AlunoDTO::fromEntity).collect(Collectors.toList());
	}
	
}
