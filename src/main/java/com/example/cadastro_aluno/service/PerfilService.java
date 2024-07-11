package com.example.cadastro_aluno.service;

import com.example.cadastro_aluno.model.Perfil;
import com.example.cadastro_aluno.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }

    public Perfil buscarPorId(Long id) {
        return perfilRepository.findById(id).orElse(null);
    }

    public void salvar(Perfil perfil) {
        perfilRepository.save(perfil);
    }

    public void deletarPorId(Long id) {
        perfilRepository.deleteById(id);
    }
}
