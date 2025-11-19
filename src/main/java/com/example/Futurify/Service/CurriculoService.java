package com.example.Futurify.Service;

import com.example.Futurify.Exceptions.CurriculoNaoEncontradoException;
import com.example.Futurify.Exceptions.TrilhaNaoEncontradaException;
import com.example.Futurify.Model.Curriculo;
import com.example.Futurify.Model.Trilhas;
import com.example.Futurify.Repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public List<Curriculo> findAll(){
        return curriculoRepository.findAll();
    }

    public void save(Curriculo curriculo){
        curriculoRepository.save(curriculo);
    }

    public void delete(Integer id){
        curriculoRepository.deleteById(id);
    }

    public Curriculo findById(Integer id){
        return curriculoRepository.findById(id)
                .orElseThrow(() -> new CurriculoNaoEncontradoException(id));
    }
}
