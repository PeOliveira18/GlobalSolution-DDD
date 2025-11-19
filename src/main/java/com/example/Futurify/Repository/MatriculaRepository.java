package com.example.Futurify.Repository;


import com.example.Futurify.Model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    List<Matricula> findAllByStatusContainingIgnoreCase(String status);

}
