package com.example.Futurify.Controller;

import com.example.Futurify.Model.AnaliseCurriculo;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Service.AnaliseCurriculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("analises_curriculo")
public class AnaliseCurriculoController {

    @Autowired
    private AnaliseCurriculoService analiseCurriculoService;

    @GetMapping("/all")
    public ResponseEntity<List<AnaliseCurriculo>> findAll() {
        List<AnaliseCurriculo> analiseCurriculos = analiseCurriculoService.findAll();
        if (analiseCurriculos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(analiseCurriculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(analiseCurriculoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody AnaliseCurriculo analiseCurriculo) {
        if (analiseCurriculo.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .body("O ID deve ser nulo ao criar uma nova analise de curriculo.");
        }

        analiseCurriculoService.save(analiseCurriculo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Analise cadastrada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody AnaliseCurriculo analiseCurriculo) {
        analiseCurriculoService.findById(id);
        analiseCurriculo.setId(id);
        analiseCurriculoService.save(analiseCurriculo);

        return ResponseEntity.ok("Analise atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        analiseCurriculoService.findById(id);
        analiseCurriculoService.delete(id);

        return ResponseEntity.ok("Analise removida com sucesso!");
    }
}
