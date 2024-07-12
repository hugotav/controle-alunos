package com.example.cadastro_aluno.repository;

import com.example.cadastro_aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query("SELECT a FROM Aluno a WHERE " +
            "(:nome IS NULL OR a.nome LIKE %:nome%) AND " +
            "(:cpf IS NULL OR a.cpf LIKE %:cpf%) AND " +
            "(:perfil IS NULL OR a.perfil.tipo LIKE %:perfil%) AND " +
            "(:email IS NULL OR a.email LIKE %:email%)")
    List<Aluno> buscarAlunos(String nome, String cpf, String perfil, String email);
}
