// package com.example.cadastro_aluno.controller;

// import com.example.cadastro_aluno.model.Aluno;
// import com.example.cadastro_aluno.service.AlunoService;
// import com.example.cadastro_aluno.service.DisciplinaService;
// import com.example.cadastro_aluno.service.PerfilService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;

// @Controller
// @RequestMapping("/alunos")
// public class AlunoController {

//     @Autowired
//     private AlunoService alunoService;
//     @Autowired
//     private DisciplinaService disciplinaService;
//     @Autowired
//     private PerfilService perfilService;

//     @GetMapping
//     public String listarTodos(Model model) {
//         List<Aluno> alunos = alunoService.listarTodos();
//         model.addAttribute("alunos", alunos);
//         model.addAttribute("template", "alunos/list");
//         return "layout";
//     }

//     @GetMapping("/novo")
//     public String mostrarFormNovoAluno(Model model) {
//         model.addAttribute("aluno", new Aluno());
//         model.addAttribute("disciplinas", disciplinaService.listarTodos());
//         model.addAttribute("perfis", perfilService.listarTodos());
//         model.addAttribute("template", "alunos/form");
//         return "layout";
//     }

//     @PostMapping
//     public String criarAluno(@ModelAttribute Aluno aluno) {
//         alunoService.salvar(aluno);
//         return "redirect:/alunos";
//     }

//     @GetMapping("/{id}")
//     public String mostrarDetalhes(@PathVariable Long id, Model model) {
//         Aluno aluno = alunoService.buscarPorId(id);
//         if (aluno != null) {
//             model.addAttribute("aluno", aluno);
//             model.addAttribute("template", "alunos/details");
//             return "layout";
//         }
//         return "redirect:/alunos";
//     }

//     @GetMapping("/{id}/editar")
//     public String mostrarFormEdicao(@PathVariable Long id, Model model) {
//         Aluno aluno = alunoService.buscarPorId(id);
//         if (aluno != null) {
//             model.addAttribute("aluno", aluno);
//             model.addAttribute("disciplinas", disciplinaService.listarTodos());
//             model.addAttribute("perfis", perfilService.listarTodos());
//             model.addAttribute("template", "alunos/form");
//             return "layout";
//         }
//         return "redirect:/alunos";
//     }

//     @PostMapping("/{id}/editar")
//     public String atualizarAluno(@PathVariable Long id, @ModelAttribute Aluno aluno) {
//         aluno.setId(id);
//         alunoService.salvar(aluno);
//         return "redirect:/alunos";
//     }

//     @GetMapping("/{id}/deletar")
//     public String deletarAluno(@PathVariable Long id) {
//         alunoService.deletarPorId(id);
//         return "redirect:/alunos";
//     }
// }
