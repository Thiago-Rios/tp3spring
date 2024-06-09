package com.infnet.tp3spring.repositories;

import com.infnet.tp3spring.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

