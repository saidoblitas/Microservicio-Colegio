package com.colegio.microservicio_colegio.service;

import com.colegio.microservicio_colegio.model.Curso;
import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> obtenerTodos();
    Optional<Curso> obtenerPorId(Long id);
    Curso guardar(Curso curso);
    Curso actualizar(Long id, Curso curso);
    void eliminar(Long id);
}
