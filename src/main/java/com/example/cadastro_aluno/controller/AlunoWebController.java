package com.example.cadastro_aluno.controller;

import com.example.cadastro_aluno.model.Aluno;
import com.example.cadastro_aluno.model.Perfil;
import com.example.cadastro_aluno.service.AlunoService;
import com.example.cadastro_aluno.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoWebController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public String listarTodos(Model model) {
        List<Aluno> alunos = alunoService.listarTodos();
        model.addAttribute("alunos", alunos);
        return "alunos/list";
    }

    @GetMapping("/novo")
    public String mostrarFormNovoAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        List<Perfil> perfis = perfilService.listarTodos();
        model.addAttribute("perfis", perfis);
        return "alunos/form";
    }

    @PostMapping
    public String criarAluno(@ModelAttribute Aluno aluno, @RequestParam Long perfilId) {
        Perfil perfil = perfilService.buscarPorId(perfilId);
        aluno.setPerfil(perfil);
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/{id}")
    public String mostrarDetalhes(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        if (aluno != null) {
            model.addAttribute("aluno", aluno);
            return "alunos/details";
        }
        return "redirect:/alunos";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormEdicao(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        if (aluno != null) {
            model.addAttribute("aluno", aluno);
            List<Perfil> perfis = perfilService.listarTodos();
            model.addAttribute("perfis", perfis);
            return "alunos/form";
        }
        return "redirect:/alunos";
    }

    @PostMapping("/{id}/editar")
    public String atualizarAluno(@PathVariable Long id, @ModelAttribute Aluno aluno, @RequestParam Long perfilId) {
        aluno.setId(id);
        Perfil perfil = perfilService.buscarPorId(perfilId);
        aluno.setPerfil(perfil);
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/{id}/deletar")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletarPorId(id);
        return "redirect:/alunos";
    }
}
