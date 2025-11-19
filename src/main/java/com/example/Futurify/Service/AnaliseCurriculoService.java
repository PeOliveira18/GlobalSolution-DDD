package com.example.Futurify.Service;


import com.example.Futurify.Exceptions.UsuarioNaoEncontradoException;
import com.example.Futurify.Model.AnaliseCurriculo;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Repository.AnaliseCurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCurriculoService {

    @Autowired
    private AnaliseCurriculoRepository analiseCurriculoRepository;

    public List<AnaliseCurriculo> findAll(){
        return analiseCurriculoRepository.findAll();
    }

    public void save(AnaliseCurriculo analiseCurriculo){
        analiseCurriculoRepository.save(analiseCurriculo);
    }

    public void delete(Integer id){
        analiseCurriculoRepository.deleteById(id);
    }

    public AnaliseCurriculo findById(Integer id){
        return analiseCurriculoRepository.findById(id).
                orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
}
