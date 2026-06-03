package com.biblioteca.app.controller;

import com.biblioteca.app.dto.BibliotecaDTO;
import com.biblioteca.app.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
@CrossOrigin(origins = "http://localhost:4200")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping
    public ResponseEntity<List<BibliotecaDTO>> obtenerTodas() {
        return ResponseEntity.ok(bibliotecaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bibliotecaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<BibliotecaDTO> crear(@RequestBody BibliotecaDTO bibliotecaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.crear(bibliotecaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BibliotecaDTO> actualizar(@PathVariable Long id, @RequestBody BibliotecaDTO bibliotecaDTO) {
        return ResponseEntity.ok(bibliotecaService.actualizar(id, bibliotecaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        bibliotecaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
