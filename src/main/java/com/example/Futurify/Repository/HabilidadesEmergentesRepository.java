package com.example.Futurify.Repository;

import com.example.Futurify.Model.HabilidadesEmergentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadesEmergentesRepository extends JpaRepository<HabilidadesEmergentes, Integer > {
    List<HabilidadesEmergentes> findAllByNomeContainingIgnoreCase(String nome);
}
