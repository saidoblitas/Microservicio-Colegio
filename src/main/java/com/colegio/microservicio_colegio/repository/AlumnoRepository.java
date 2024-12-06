package com.colegio.microservicio_colegio.repository;

import com.colegio.microservicio_colegio.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
