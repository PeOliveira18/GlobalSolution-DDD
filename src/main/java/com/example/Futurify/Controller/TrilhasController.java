package com.example.Futurify.Controller;

import com.example.Futurify.Model.Trilhas;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Service.TrilhasService;
import com.example.Futurify.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
@CrossOrigin("*")
public class TrilhasController {

    @Autowired
    private TrilhasService trilhasService;

    @GetMapping("/all")
    public ResponseEntity<List<Trilhas>> findAll() {
        List<Trilhas> trilhas = trilhasService.findAll();
        if (trilhas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(trilhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(trilhasService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Trilhas trilhas) {
        if (trilhas.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .body("O ID deve ser nulo ao criar uma trilha.");
        }

        trilhasService.save(trilhas);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Trilha cadastrada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody Trilhas trilhas) {
        trilhasService.findById(id);
        trilhas.setId(id);
        trilhasService.save(trilhas);
        return ResponseEntity.ok("Trilha atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        trilhasService.findById(id);
        trilhasService.delete(id);
        return ResponseEntity.ok("Trilha removida com sucesso!");
    }
}
