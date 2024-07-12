package com.example.cadastro_aluno.controller;

import com.example.cadastro_aluno.model.Aluno;
import com.example.cadastro_aluno.model.Perfil;
import com.example.cadastro_aluno.service.AlunoService;
import com.example.cadastro_aluno.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/alunos") // URL base para os endpoints da API
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private PerfilService perfilService;

    // Endpoint para listar todos os alunos com parâmetros de filtro
    @GetMapping
    public ResponseEntity<Map<String, Object>> listarAlunos(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String perfil,
            @RequestParam(required = false) String email) {

        List<Aluno> alunos = alunoService.buscarAlunos(nome, cpf, perfil, email);
        Map<String, Object> response = new HashMap<>();
        response.put("data", alunos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para buscar um aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        if (aluno != null) {
            return new ResponseEntity<>(aluno, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para criar um novo aluno
    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        alunoService.salvar(aluno);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um aluno existente
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(
            @PathVariable Long id,
            @RequestBody Aluno aluno) {
        aluno.setId(id);
        alunoService.salvar(aluno);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    // Endpoint para deletar um aluno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
