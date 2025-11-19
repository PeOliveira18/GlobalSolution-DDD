package com.example.Futurify.Service;

import com.example.Futurify.Exceptions.CompetenciaNaoEncontradaException;
import com.example.Futurify.Model.Competencias;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Repository.CompetenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciasService {
    @Autowired
    private CompetenciasRepository competenciasRepository;

    public List<Competencias> findAll(){
        return competenciasRepository.findAll();
    }

    public void save(Competencias competencias){
        competenciasRepository.save(competencias);
    }

    public void delete(Integer id){
        competenciasRepository.deleteById(id);
    }

    public Competencias findById(Integer id){
        return competenciasRepository.findById(id).
                orElseThrow(() -> new CompetenciaNaoEncontradaException(id));
    }

}
