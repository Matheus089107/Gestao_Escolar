package com.castro.DTO.GestaoEscolar.repository;

import com.castro.DTO.GestaoEscolar.model.Professor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProfessorRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public void salvar(Professor p) {
        String sql = "INSERT INTO professor (nome, email, disciplina) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, p.getNome(), p.getEmail(), p.getDisciplina());
    }

    public Professor buscarPorId(Long id) {
        String sql = "SELECT * FROM professor WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Professor(rs.getLong("id"), rs.getString("nome"), rs.getString("email"), rs.getString("disciplina")), id);
    }
}
