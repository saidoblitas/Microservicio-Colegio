package com.colegio.microservicio_colegio.service.impl;

import com.colegio.microservicio_colegio.model.Curso;
import com.colegio.microservicio_colegio.repository.CursoRepository;
import com.colegio.microservicio_colegio.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizar(Long id, Curso curso) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isPresent()) {
            Curso actualizado = cursoExistente.get();
            actualizado.setNombre(curso.getNombre());
            actualizado.setDescripcion(curso.getDescripcion());
            actualizado.setCreditos(curso.getCreditos());
            actualizado.setDuracion(curso.getDuracion());
            return cursoRepository.save(actualizado);
        }
        throw new RuntimeException("Curso no encontrado");
    }

    @Override
    public void eliminar(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Curso no encontrado para eliminar");
        }
    }
}
