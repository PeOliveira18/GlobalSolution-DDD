package com.example.Futurify.Repository;


import com.example.Futurify.Model.Competencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciasRepository extends JpaRepository<Competencias, Integer> {
    List<Competencias> findAllByNomeContainingIgnoreCase(String nome);
}
