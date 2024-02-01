package com.control.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.entities.Aluno;
import com.control.services.AlunoService;


@RestController
@RequestMapping("/Aluno")
public class AlunoController {

	private final AlunoService AlunoService;

	@Autowired
	public AlunoController(AlunoService AlunoService) {
		this.AlunoService = AlunoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id) {
		Aluno Aluno = AlunoService.getAlunoById(id);
		if (Aluno != null) {
			return ResponseEntity.ok(Aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aluno>> buscaTodosAlunosControl() {
		List<Aluno> Alunos = AlunoService.getAllAlunos();
		return ResponseEntity.ok(Alunos);
	}

	@PostMapping("/")
	public ResponseEntity<Aluno> saveAlunosControl(@RequestBody Aluno Aluno) {
		Aluno saveAluno = AlunoService.saveAluno(Aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAluno);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Aluno> alteraAlunoControl(@PathVariable Long id, @RequestBody Aluno Aluno) {
		Aluno alteraAluno = AlunoService.changeAluno(id, Aluno);

		if (alteraAluno != null) {
			return ResponseEntity.ok(Aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAlunoControl(@PathVariable Long id) {
		boolean delete = AlunoService.deleteAluno(id);
		if (delete) {
			return ResponseEntity.ok().body("O Aluno foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
