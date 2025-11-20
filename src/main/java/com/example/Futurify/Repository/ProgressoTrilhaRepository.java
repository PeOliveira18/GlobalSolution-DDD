package com.example.Futurify.Repository;

import com.example.Futurify.Model.ProgressoTrilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProgressoTrilhaRepository extends JpaRepository<ProgressoTrilha, Integer> {

    List<ProgressoTrilha> findAllByPercentual(BigDecimal percentual);

}
