package com.colegio.microservicio_colegio.service.impl;

import com.colegio.microservicio_colegio.model.Alumno;
import com.colegio.microservicio_colegio.repository.AlumnoRepository;
import com.colegio.microservicio_colegio.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> obtenerPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno actualizar(Long id, Alumno alumno) {
        Optional<Alumno> alumnoExistente = alumnoRepository.findById(id);
        if (alumnoExistente.isPresent()) {
            Alumno actualizado = alumnoExistente.get();
            actualizado.setNombre(alumno.getNombre());
            actualizado.setEdad(alumno.getEdad());
            actualizado.setGrado(alumno.getGrado());
            return alumnoRepository.save(actualizado);
        }
        throw new RuntimeException("Alumno no encontrado");
    }

    @Override
    public void eliminar(Long id) {
        alumnoRepository.deleteById(id);
    }
}
