package com.colegio.microservicio_colegio.controller;

import com.colegio.microservicio_colegio.model.Alumno;
import com.colegio.microservicio_colegio.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> obtenerTodos() {
        return alumnoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.obtenerPorId(id);
        return alumno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alumno> guardar(@RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.guardar(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.actualizar(id, alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
