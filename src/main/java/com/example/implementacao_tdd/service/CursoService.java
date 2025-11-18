package com.example.implementacao_tdd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.implementacao_tdd.repository.*;
import com.example.implementacao_tdd.entity.*;
import com.example.implementacao_tdd.dto.*;

@Service
public class CursoService {

	@Autowired
	private CursoRepository curso_repository;
	
	public List<CursoDTO> getAllCursos() {
		List<Curso> cursos = this.curso_repository.findAll();
		return cursos.stream().map(CursoDTO::fromEntity).collect(Collectors.toList());
	}
}
