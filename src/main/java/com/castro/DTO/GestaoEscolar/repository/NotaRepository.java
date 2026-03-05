package com.castro.DTO.GestaoEscolar.repository;

import com.castro.DTO.GestaoEscolar.model.Nota;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotaRepository {
    private final JdbcTemplate jdbcTemplate;

    public NotaRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public void salvar(Nota nota) {

        String sql = "INSERT INTO nota (aluno_id, aula_id, valor) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, nota.getAlunoId(), nota.getAulaId(), nota.getValor());
    }

    public List<Nota> buscarPorAluno(Long alunoId) {
        String sql = "SELECT * FROM nota WHERE aluno_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Nota(rs.getLong("id"), rs.getLong("aluno_id"), rs.getLong("aula_id"), rs.getDouble("valor")), alunoId);
    }
    public List<Nota> getNotasByAluno(Long alunoId) {
        String sql = "SELECT * FROM nota WHERE aluno_id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Nota nota = new Nota();
            nota.setId(rs.getLong("id"));
            nota.setAlunoId(rs.getLong("aluno_id"));
            nota.setAulaId(rs.getLong("aula_id"));
            nota.setValor(rs.getDouble("valor"));
            return nota;
        }, alunoId);
    }
}