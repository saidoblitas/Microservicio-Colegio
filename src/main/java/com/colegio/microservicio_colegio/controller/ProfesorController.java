package com.colegio.microservicio_colegio.controller;

import com.colegio.microservicio_colegio.model.Profesor;
import com.colegio.microservicio_colegio.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> obtenerTodos() {
        return profesorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorService.obtenerPorId(id);
        return profesor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Profesor> guardar(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.guardar(profesor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id, @RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.actualizar(id, profesor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
