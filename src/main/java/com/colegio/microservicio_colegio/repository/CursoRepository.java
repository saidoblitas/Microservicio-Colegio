package com.colegio.microservicio_colegio.repository;

import com.colegio.microservicio_colegio.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
