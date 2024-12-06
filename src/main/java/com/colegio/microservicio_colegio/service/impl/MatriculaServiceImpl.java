package com.colegio.microservicio_colegio.service.impl;

import com.colegio.microservicio_colegio.model.Matricula;
import com.colegio.microservicio_colegio.repository.MatriculaRepository;
import com.colegio.microservicio_colegio.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> obtenerTodos() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> obtenerPorId(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula actualizar(Long id, Matricula matricula) {
        Optional<Matricula> matriculaExistente = matriculaRepository.findById(id);
        if (matriculaExistente.isPresent()) {
            Matricula actualizada = matriculaExistente.get();
            actualizada.setAlumno(matricula.getAlumno());
            actualizada.setCurso(matricula.getCurso());
            actualizada.setFechaMatricula(matricula.getFechaMatricula());
            return matriculaRepository.save(actualizada);
        }
        throw new RuntimeException("Matricula no encontrada");
    }

    @Override
    public void eliminar(Long id) {
        matriculaRepository.deleteById(id);
    }
}
