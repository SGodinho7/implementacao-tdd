package com.example.implementacao_tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.implementacao_tdd.entity.*;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
}
