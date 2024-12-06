package com.colegio.microservicio_colegio.controller;

import com.colegio.microservicio_colegio.model.Curso;
import com.colegio.microservicio_colegio.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> obtenerTodos() {
        return cursoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.obtenerPorId(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.guardar(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.actualizar(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
