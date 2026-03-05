package com.castro.DTO.GestaoEscolar.repository;


import com.castro.DTO.GestaoEscolar.model.Curso;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class CursoRepository {
    private final JdbcTemplate jdbcTemplate;

    public CursoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long salvar(Curso curso) {
        String sql = "INSERT INTO curso (nome, codigo) VALUES (?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getCodigo());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    public Curso buscarPorId(Long id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Curso(rs.getLong("id"), rs.getString("nome"), rs.getString("codigo")), id);
    }
}