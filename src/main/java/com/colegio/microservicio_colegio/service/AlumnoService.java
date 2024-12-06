package com.colegio.microservicio_colegio.service;

import com.colegio.microservicio_colegio.model.Alumno;
import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<Alumno> obtenerTodos();
    Optional<Alumno> obtenerPorId(Long id);
    Alumno guardar(Alumno alumno);
    Alumno actualizar(Long id, Alumno alumno);
    void eliminar(Long id);
}
