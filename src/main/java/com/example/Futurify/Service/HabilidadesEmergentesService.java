package com.example.Futurify.Service;

import com.example.Futurify.Exceptions.HabilidadesEmergentesNaoEncontradaException;
import com.example.Futurify.Exceptions.MatriculaNaoEncontradaException;
import com.example.Futurify.Model.HabilidadesEmergentes;
import com.example.Futurify.Model.Matricula;
import com.example.Futurify.Repository.HabilidadesEmergentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadesEmergentesService {

    @Autowired
    private HabilidadesEmergentesRepository habilidadesEmergentesRepository;

    public List<HabilidadesEmergentes> findAll(){
        return habilidadesEmergentesRepository.findAll();
    }

    public void save(HabilidadesEmergentes habilidadesEmergentes){
        habilidadesEmergentesRepository.save(habilidadesEmergentes);
    }

    public void delete(Integer id){
        habilidadesEmergentesRepository.deleteById(id);
    }

    public HabilidadesEmergentes findById(Integer id){
        return habilidadesEmergentesRepository.findById(id)
                .orElseThrow(() -> new HabilidadesEmergentesNaoEncontradaException(id));
    }
}
