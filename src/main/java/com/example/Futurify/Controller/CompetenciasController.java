package com.example.Futurify.Controller;

import com.example.Futurify.Model.Competencias;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Service.CompetenciasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencias")
public class CompetenciasController {

    @Autowired
    private CompetenciasService competenciasService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Competencias> competencias = competenciasService.findAll();
        if (competencias.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhuma competência cadastrada.");
        }
        return ResponseEntity.ok(competencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(competenciasService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Competencias competencias) {
        if (competencias.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .body("O ID deve ser nulo ao criar uma nova competência.");
        }

        competenciasService.save(competencias);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Competência cadastrada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody Competencias competencias) {
        competenciasService.findById(id);
        competencias.setId(id);
        competenciasService.save(competencias);

        return ResponseEntity.ok("Competência atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        competenciasService.findById(id);
        competenciasService.delete(id);
        return ResponseEntity.ok("Competência removida com sucesso!");
    }
}
