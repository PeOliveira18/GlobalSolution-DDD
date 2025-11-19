package com.example.Futurify.Service;

import com.example.Futurify.Exceptions.TrilhaNaoEncontradaException;
import com.example.Futurify.Model.Trilhas;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Repository.TrilhasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhasService {

    @Autowired
    private TrilhasRepository trilhasRepository;

    public List<Trilhas> findAll(){
        return trilhasRepository.findAll();
    }

    public void save(Trilhas trilhas){
        trilhasRepository.save(trilhas);
    }

    public void delete(Integer id){
        trilhasRepository.deleteById(id);
    }

    public Trilhas findById(Integer id){
        return trilhasRepository.findById(id)
                .orElseThrow(() -> new TrilhaNaoEncontradaException(id));
    }
}
