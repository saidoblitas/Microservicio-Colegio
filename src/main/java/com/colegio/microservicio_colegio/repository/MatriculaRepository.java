package com.colegio.microservicio_colegio.repository;

import com.colegio.microservicio_colegio.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
