package com.infnet.tp3spring.services;

import com.infnet.tp3spring.models.Aluno;
import com.infnet.tp3spring.models.Curso;
import com.infnet.tp3spring.repositories.AlunoRepository;
import com.infnet.tp3spring.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoCursoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // Aluno CRUD
    public Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> getAlunoById(Long id) {
        return alunoRepository.findById(id);
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    // Curso CRUD
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
