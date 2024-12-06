package com.colegio.microservicio_colegio.service.impl;

import com.colegio.microservicio_colegio.model.Profesor;
import com.colegio.microservicio_colegio.repository.ProfesorRepository;
import com.colegio.microservicio_colegio.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> obtenerPorId(Long id) {
        return profesorRepository.findById(id);
    }

    @Override
    public Profesor guardar(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor actualizar(Long id, Profesor profesor) {
        Optional<Profesor> profesorExistente = profesorRepository.findById(id);
        if (profesorExistente.isPresent()) {
            Profesor actualizado = profesorExistente.get();
            actualizado.setNombre(profesor.getNombre());
            actualizado.setEspecialidad(profesor.getEspecialidad());
            actualizado.setEdad(profesor.getEdad());
            return profesorRepository.save(actualizado);
        }
        throw new RuntimeException("Profesor no encontrado");
    }

    @Override
    public void eliminar(Long id) {
        profesorRepository.deleteById(id);
    }
}
