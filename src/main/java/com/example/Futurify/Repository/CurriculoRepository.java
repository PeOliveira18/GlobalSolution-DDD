package com.example.Futurify.Repository;

import com.example.Futurify.Model.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Integer> {
    List<Curriculo> findAllByTituloContainingIgnoreCase(String titulo);

}
