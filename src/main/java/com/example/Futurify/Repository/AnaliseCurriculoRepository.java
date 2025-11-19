package com.example.Futurify.Repository;

import com.example.Futurify.Model.AnaliseCurriculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnaliseCurriculoRepository extends JpaRepository<AnaliseCurriculo, Integer> {

    List<AnaliseCurriculo> findAllByCaminhoArquivoContainingIgnoreCase(String caminhoArquivo);
}
