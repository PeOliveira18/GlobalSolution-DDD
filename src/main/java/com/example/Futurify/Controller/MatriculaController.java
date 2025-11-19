package com.example.Futurify.Controller;

import com.example.Futurify.Model.Matricula;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/all")
    public ResponseEntity<List<Matricula>> findAll() {
        List<Matricula> matriculas = matriculaService.findAll();
        if (matriculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(matriculaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Matricula matricula) {
        if (matricula.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .body("O ID deve ser nulo ao criar uma nova matrícula.");
        }

        matriculaService.save(matricula);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Matrícula cadastrada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody Matricula matricula) {
        matriculaService.findById(id);
        matricula.setId(id);
        matriculaService.save(matricula);

        return ResponseEntity.ok("Matrícula atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        matriculaService.findById(id);
        matriculaService.delete(id);
        return ResponseEntity.ok("Matrícula removida com sucesso!");
    }
}
