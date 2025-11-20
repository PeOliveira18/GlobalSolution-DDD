package com.example.Futurify.Controller;

import com.example.Futurify.Model.AnaliseCurriculo;
import com.example.Futurify.Model.ProgressoTrilha;
import com.example.Futurify.Service.ProgressoTrilhaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progresso_trilha")
public class ProgressoTrilhaController {

    @Autowired
    private ProgressoTrilhaService progressoTrilhaService;

    @GetMapping("/all")
    public ResponseEntity<List<ProgressoTrilha>> findAll() {
        List<ProgressoTrilha> progressoTrilhas = progressoTrilhaService.findAll();
        if (progressoTrilhas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(progressoTrilhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(progressoTrilhaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProgressoTrilha progressoTrilha) {
        if (progressoTrilha.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .body("O ID deve ser nulo ao criar um novo progresso de trilha.");
        }

        progressoTrilhaService.save(progressoTrilha);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Progresso de trilha cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody ProgressoTrilha progressoTrilha) {
        progressoTrilhaService.findById(id);
        progressoTrilha.setId(id);
        progressoTrilhaService.save(progressoTrilha);

        return ResponseEntity.ok("Progresso de trilha atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        progressoTrilhaService.findById(id);
        progressoTrilhaService.delete(id);

        return ResponseEntity.ok("Progresso de trilha removido com sucesso!");
    }
}
