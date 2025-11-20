package com.example.Futurify.Service;

import com.example.Futurify.Exceptions.ProgressoTrilhaNaoEncontradaException;
import com.example.Futurify.Exceptions.UsuarioNaoEncontradoException;
import com.example.Futurify.Model.AnaliseCurriculo;
import com.example.Futurify.Model.ProgressoTrilha;
import com.example.Futurify.Repository.ProgressoTrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressoTrilhaService {

    @Autowired
    private ProgressoTrilhaRepository progressoTrilhaRepository;

    public List<ProgressoTrilha> findAll(){
        return progressoTrilhaRepository.findAll();
    }

    public void save(ProgressoTrilha progressoTrilha){
        progressoTrilhaRepository.save(progressoTrilha);
    }

    public void delete(Integer id){
        progressoTrilhaRepository.deleteById(id);
    }

    public ProgressoTrilha findById(Integer id){
        return progressoTrilhaRepository.findById(id).
                orElseThrow(() -> new ProgressoTrilhaNaoEncontradaException(id));
    }
}
