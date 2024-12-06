package com.colegio.microservicio_colegio.controller;

import com.colegio.microservicio_colegio.model.Matricula;
import com.colegio.microservicio_colegio.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> obtenerTodos() {
        return matriculaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtenerPorId(@PathVariable Long id) {
        Optional<Matricula> matricula = matriculaService.obtenerPorId(id);
        return matricula.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Matricula> guardar(@RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.guardar(matricula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> actualizar(@PathVariable Long id, @RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.actualizar(id, matricula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
