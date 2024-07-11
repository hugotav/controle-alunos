package com.example.cadastro_aluno.controller;

import com.example.cadastro_aluno.model.Perfil;
import com.example.cadastro_aluno.service.PerfilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/perfis")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public String listarTodos(Model model) {
        List<Perfil> perfis = perfilService.listarTodos();
        model.addAttribute("perfis", perfis);
        return "perfis/list";
    }

    @GetMapping("/novo")
    public String mostrarFormNovoPerfil(Model model) {
        model.addAttribute("perfil", new Perfil());
        return "perfis/form";
    }

    @PostMapping
    public String criarPerfil(Perfil perfil) {
        perfilService.salvar(perfil);
        return "redirect:/perfis";
    }

    @GetMapping("/{id}")
    public String mostrarDetalhes(@PathVariable Long id, Model model) {
        Perfil perfil = perfilService.buscarPorId(id);
        if (perfil != null) {
            model.addAttribute("perfil", perfil);
            return "perfis/details";
        }
        return "redirect:/perfis";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormEdicao(@PathVariable Long id, Model model) {
        Perfil perfil = perfilService.buscarPorId(id);
        if (perfil != null) {
            model.addAttribute("perfil", perfil);
            return "perfis/form";
        }
        return "redirect:/perfis";
    }

    @PostMapping("/{id}/editar")
    public String atualizarPerfil(@PathVariable Long id, Perfil perfil) {
        perfil.setId(id);
        perfilService.salvar(perfil);
        return "redirect:/perfis";
    }

    @GetMapping("/{id}/deletar")
    public String deletarPerfil(@PathVariable Long id) {
        perfilService.deletarPorId(id);
        return "redirect:/perfis";
    }
}
