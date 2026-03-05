package com.castro.DTO.GestaoEscolar.repository;

import com.castro.DTO.GestaoEscolar.model.Turma;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TurmaRepository {

    private final JdbcTemplate jdbcTemplate;

    public TurmaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Long salvar(Turma turma) {
        String sql = "INSERT INTO turma (nome, curso_id, professor_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, turma.getNome(), turma.getCursoId(), turma.getProfessorId());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    public Turma buscarPorId(Long id) {
        String sql = "SELECT * FROM turma WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Turma t = new Turma();
            t.setId(rs.getLong("id"));
            t.setNome(rs.getString("nome"));
            t.setCursoId(rs.getLong("curso_id"));
            t.setProfessorId(rs.getLong("professor_id"));
            return t;
        }, id);
    }
    public Turma buscarComNomes(Long id) {
        return buscarPorId(id);
    }

    public List<String> buscarNomesAlunos(Long turmaId) {
        String sql = "SELECT a.nome FROM aluno a " +
                "JOIN turma_aluno ta ON a.id = ta.aluno_id " +
                "WHERE ta.turma_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("nome"), turmaId);
    }

    public void vincularAluno(Long turmaId, Long alunoId) {
        String sql = "INSERT INTO turma_aluno (turma_id, aluno_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, turmaId, alunoId);
    }
    public List<Turma> listarPorCurso(Long cursoId) {
        String sql = "SELECT * FROM turma WHERE curso_id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Turma turma = new Turma();
            turma.setId(rs.getLong("id"));
            turma.setNome(rs.getString("nome"));
            turma.setCursoId(rs.getLong("curso_id"));
            turma.setProfessorId(rs.getLong("professor_id"));
            return turma;
        }, cursoId);
    }
}