package com.castro.DTO.GestaoEscolar.repository;

import com.castro.DTO.GestaoEscolar.model.Aula;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AulaRepository {
    private final JdbcTemplate jdbcTemplate;

    public AulaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long salvar(Aula aula) {
        String sql = "INSERT INTO aula (turma_id, data_hora, assunto) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, aula.getTurmaId(), aula.getDataHora(), aula.getAssunto());

        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }


    public Aula buscarPorId(Long id) {
        String sql = "SELECT * FROM aula WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Aula a = new Aula();
            a.setId(rs.getLong("id"));
            a.setTurmaId(rs.getLong("turma_id"));
            a.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
            a.setAssunto(rs.getString("assunto"));
            return a;
        }, id);
    }
    public List<Aula> buscarPorTurma(Long turmaId) {
        String sql = "SELECT * FROM aula WHERE turma_id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Aula aula = new Aula();
            aula.setId(rs.getLong("id"));
            aula.setTurmaId(rs.getLong("turma_id"));

            aula.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
            aula.setAssunto(rs.getString("assunto"));

            return aula;
        }, turmaId);
    }
}