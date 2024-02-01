package com.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}