package com.example.Futurify.Repository;

import com.example.Futurify.Model.Trilhas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrilhasRepository extends JpaRepository<Trilhas, Integer> {
    List<Trilhas> findAllByNomeContainingIgnoreCase(String nome);

}
