package com.example.implementacao_tdd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.implementacao_tdd.dto.*;
import com.example.implementacao_tdd.service.*;

@RestController
@CrossOrigin
@RequestMapping("/contas")
public class ContaController {
	@Autowired
    private ContaService contaService;

    @GetMapping
    public List<ContaDTO> getContas() {
        return contaService.getAllContas();
    }
}
