package com.example.Futurify.Repository;


import com.example.Futurify.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
