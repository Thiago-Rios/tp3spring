package com.infnet.tp3spring.controller;

import com.infnet.tp3spring.models.Aluno;
import com.infnet.tp3spring.models.Curso;
import com.infnet.tp3spring.models.MaterialDidatico;
import com.infnet.tp3spring.services.AlunoCursoService;
import com.infnet.tp3spring.services.MaterialDidaticoService;
import com.infnet.tp3spring.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private AlunoCursoService alunoCursoService;

    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    @Autowired
    private RedisService redisService;

    // Aluno Endpoints

    @PostMapping("/alunos")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoCursoService.saveAluno(aluno);
    }

    @GetMapping("/alunos")
    public List<Aluno> getAllAlunos() {
        return alunoCursoService.getAllAlunos();
    }

    @GetMapping("/alunos/{id}")
    public Optional<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoCursoService.getAlunoById(id);
    }

    @PutMapping("/alunos/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno alunoDetails) {
        Optional<Aluno> aluno = alunoCursoService.getAlunoById(id);
        if (aluno.isPresent()) {
            Aluno existingAluno = aluno.get();
            existingAluno.setNome(alunoDetails.getNome());
            // Atualize outros campos conforme necessário
            return alunoCursoService.saveAluno(existingAluno);
        }
        return null; // ou lance uma exceção apropriada
    }

    @DeleteMapping("/alunos/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoCursoService.deleteAluno(id);
    }

    // Curso Endpoints

    @PostMapping("/cursos")
    public Curso createCurso(@RequestBody Curso curso) {
        return alunoCursoService.saveCurso(curso);
    }

    @GetMapping("/cursos")
    public List<Curso> getAllCursos() {
        return alunoCursoService.getAllCursos();
    }

    @GetMapping("/cursos/{id}")
    public Optional<Curso> getCursoById(@PathVariable Long id) {
        return alunoCursoService.getCursoById(id);
    }

    @PutMapping("/cursos/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Optional<Curso> curso = alunoCursoService.getCursoById(id);
        if (curso.isPresent()) {
            Curso existingCurso = curso.get();
            existingCurso.setNome(cursoDetails.getNome());
            // Atualize outros campos conforme necessário
            return alunoCursoService.saveCurso(existingCurso);
        }
        return null; // ou lance uma exceção apropriada
    }

    @DeleteMapping("/cursos/{id}")
    public void deleteCurso(@PathVariable Long id) {
        alunoCursoService.deleteCurso(id);
    }

    // Redis Endpoints para Curso

    @PostMapping("/cursos/cache")
    public void cacheCurso(@RequestParam String key, @RequestBody Curso curso) {
        redisService.cacheCurso(key, curso);
    }

    @GetMapping("/cursos/cache")
    public Object getCursoFromCache(@RequestParam String key) {
        return redisService.getCursoFromCache(key);
    }

    @DeleteMapping("/cursos/cache")
    public void removeCursoFromCache(@RequestParam String key) {
        redisService.removeCursoFromCache(key);
    }

    // MaterialDidatico Endpoints

    @PostMapping("/materiais")
    public MaterialDidatico createMaterialDidatico(@RequestBody MaterialDidatico materialDidatico) {
        return materialDidaticoService.saveMaterialDidatico(materialDidatico);
    }

    @GetMapping("/materiais")
    public List<MaterialDidatico> getAllMateriais() {
        return materialDidaticoService.getAllMaterialDidatico();
    }

    @GetMapping("/materiais/{id}")
    public Optional<MaterialDidatico> getMaterialDidaticoById(@PathVariable String id) {
        return materialDidaticoService.getMaterialDidaticoById(id);
    }

    @PutMapping("/materiais/{id}")
    public MaterialDidatico updateMaterialDidatico(@PathVariable String id, @RequestBody MaterialDidatico materialDidaticoDetails) {
        Optional<MaterialDidatico> materialDidatico = materialDidaticoService.getMaterialDidaticoById(id);
        if (materialDidatico.isPresent()) {
            MaterialDidatico existingMaterialDidatico = materialDidatico.get();
            existingMaterialDidatico.setNome(materialDidaticoDetails.getNome());
            existingMaterialDidatico.setConteudo(materialDidaticoDetails.getConteudo());
            // Atualize outros campos conforme necessário
            return materialDidaticoService.saveMaterialDidatico(existingMaterialDidatico);
        }
        return null; // ou lance uma exceção apropriada
    }

    @DeleteMapping("/materiais/{id}")
    public void deleteMaterialDidatico(@PathVariable String id) {
        materialDidaticoService.deleteMaterialDidatico(id);
    }
}
