package com.example.Futurify.Controller;


import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Usuario usuario) {
        if (usuario.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .body("O ID deve ser nulo ao criar um novo usuário.");
        }

        usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
        usuarioService.findById(id);
        usuario.setId(id);
        usuarioService.save(usuario);

        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        usuarioService.findById(id);
        usuarioService.delete(id);

        return ResponseEntity.ok("Usuário removido com sucesso!");
    }
}
