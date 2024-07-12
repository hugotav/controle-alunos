package com.example.cadastro_aluno.controller;

import com.example.cadastro_aluno.model.Perfil;
import com.example.cadastro_aluno.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfis") // URL base para os endpoints dos perfis
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    // Endpoint para listar todos os perfis
    @GetMapping
    public ResponseEntity<List<Perfil>> listarPerfis() {
        List<Perfil> perfis = perfilService.listarTodos();
        return new ResponseEntity<>(perfis, HttpStatus.OK);
    }
}
