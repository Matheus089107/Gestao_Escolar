package com.castro.DTO.GestaoEscolar.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TurmaAlunoRepository {
    private final JdbcTemplate jdbcTemplate;

    public TurmaAlunoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void matricular(Long turmaId, Long alunoId) {
        String sql = "INSERT INTO turma_aluno (turma_id, aluno_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, turmaId, alunoId);
    }
}
