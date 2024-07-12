package com.example.cadastro_aluno.service;

import com.example.cadastro_aluno.model.Aluno;
import com.example.cadastro_aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public void deletarPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    public List<Aluno> buscarAlunos(String nome, String cpf, String perfil, String email) {
        return alunoRepository.buscarAlunos(nome, cpf, perfil, email);
    }
}
