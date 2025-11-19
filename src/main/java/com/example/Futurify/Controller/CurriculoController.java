package com.example.Futurify.Controller;


import com.example.Futurify.Model.Curriculo;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Service.CurriculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @GetMapping("/all")
    public ResponseEntity<List<Curriculo>> findAll() {
        List<Curriculo> curriculos = curriculoService.findAll();
        if (curriculos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(curriculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(curriculoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Curriculo curriculo) {
        if (curriculo.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .body("O ID deve ser nulo ao criar um novo curriculo.");
        }

        curriculoService.save(curriculo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Curriculo regisrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody Curriculo curriculo) {
        curriculoService.findById(id);
        curriculo.setId(id);
        curriculoService.save(curriculo);

        return ResponseEntity.ok("Curriculo atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        curriculoService.findById(id);
        curriculoService.delete(id);

        return ResponseEntity.ok("Curriculo removido com sucesso!");
    }
}
