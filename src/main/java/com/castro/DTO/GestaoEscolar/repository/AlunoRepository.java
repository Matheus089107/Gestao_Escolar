package com.castro.DTO.GestaoEscolar.repository;

import com.castro.DTO.GestaoEscolar.model.Aluno;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlunoRepository {
    private final JdbcTemplate jdbcTemplate;

    public AlunoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Aluno> alunoMapper = (rs, rowNum) -> new Aluno(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getString("email"),
            rs.getString("matricula"),
            rs.getDate("data_nascimento").toLocalDate()
    );

    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, email, matricula, data_nascimento) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, aluno.getNome(), aluno.getEmail(), aluno.getMatricula(), aluno.getDataNascimento());
    }

    public Aluno buscarPorId(Long id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, alunoMapper, id);
    }

    public List<Aluno> listarTodos() {
        return jdbcTemplate.query("SELECT * FROM aluno", alunoMapper);
    }

    public void deletar(Long id) {
        jdbcTemplate.update("DELETE FROM aluno WHERE id = ?", id);
    }
}