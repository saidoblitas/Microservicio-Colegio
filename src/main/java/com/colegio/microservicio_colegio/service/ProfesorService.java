package com.colegio.microservicio_colegio.service;

import com.colegio.microservicio_colegio.model.Profesor;
import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<Profesor> obtenerTodos();
    Optional<Profesor> obtenerPorId(Long id);
    Profesor guardar(Profesor profesor);
    Profesor actualizar(Long id, Profesor profesor);
    void eliminar(Long id);
}
