package com.control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.entities.Aluno;
import com.control.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository AlunoRepository;

	@Autowired
	public AlunoService(AlunoRepository AlunoRepository) {
		this.AlunoRepository = AlunoRepository;
	}

	public List<Aluno> getAllAlunos() {
		return AlunoRepository.findAll();
	}

	public Aluno getAlunoById(Long id) {
		Optional<Aluno> Aluno = AlunoRepository.findById(id);
		return Aluno.orElse(null);
	}

	public Aluno saveAluno(Aluno Aluno) {
		return AlunoRepository.save(Aluno);
	}

	public Aluno changeAluno(Long id, Aluno changeProd) {
		Optional<Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			changeProd.setId(id);
			return AlunoRepository.save(changeProd);
		}
		return null;
	}

	public boolean deleteAluno(Long id) {
		Optional<Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			AlunoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
