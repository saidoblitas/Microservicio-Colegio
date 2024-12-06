package com.colegio.microservicio_colegio.service;

import com.colegio.microservicio_colegio.model.Matricula;
import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    List<Matricula> obtenerTodos();
    Optional<Matricula> obtenerPorId(Long id);
    Matricula guardar(Matricula matricula);
    Matricula actualizar(Long id, Matricula matricula);
    void eliminar(Long id);
}
