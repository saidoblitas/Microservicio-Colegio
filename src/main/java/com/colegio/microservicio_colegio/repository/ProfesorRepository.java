package com.colegio.microservicio_colegio.repository;

import com.colegio.microservicio_colegio.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
