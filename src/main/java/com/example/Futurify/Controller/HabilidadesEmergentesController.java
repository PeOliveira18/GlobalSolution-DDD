package com.example.Futurify.Controller;


import com.example.Futurify.Model.HabilidadesEmergentes;
import com.example.Futurify.Model.Trilhas;
import com.example.Futurify.Service.HabilidadesEmergentesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades_emergentes")
public class HabilidadesEmergentesController {

    @Autowired
    private HabilidadesEmergentesService habilidadesEmergentesService;

    @GetMapping("/all")
    public ResponseEntity<List<HabilidadesEmergentes>> findAll() {
        List<HabilidadesEmergentes> habilidadesEmergentes = habilidadesEmergentesService.findAll();
        if (habilidadesEmergentes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(habilidadesEmergentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(habilidadesEmergentesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody HabilidadesEmergentes habilidadesEmergentes) {
        if (habilidadesEmergentes.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .body("O ID deve ser nulo ao criar uma habilidade.");
        }

        habilidadesEmergentesService.save(habilidadesEmergentes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Habilidade cadastrada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody HabilidadesEmergentes habilidadesEmergentes) {
        habilidadesEmergentesService.findById(id);
        habilidadesEmergentes.setId(id);
        habilidadesEmergentesService.save(habilidadesEmergentes);
        return ResponseEntity.ok("Habilidade atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        habilidadesEmergentesService.findById(id);
        habilidadesEmergentesService.delete(id);
        return ResponseEntity.ok("Habilidade removida com sucesso!");
    }
}
