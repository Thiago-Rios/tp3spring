package com.infnet.tp3spring.repositories;

import com.infnet.tp3spring.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
