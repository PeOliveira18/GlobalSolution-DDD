package com.example.Futurify.Service;


import com.example.Futurify.Exceptions.MatriculaNaoEncontradaException;
import com.example.Futurify.Model.Matricula;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula> findAll(){
        return matriculaRepository.findAll();
    }

    public void save(Matricula matricula){
        matriculaRepository.save(matricula);
    }

    public void delete(Integer id){
        matriculaRepository.deleteById(id);
    }

    public Matricula findById(Integer id){
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new MatriculaNaoEncontradaException(id));
    }
}
