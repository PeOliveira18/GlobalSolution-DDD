package com.example.Futurify.Service;


import com.example.Futurify.Exceptions.UsuarioNaoEncontradoException;
import com.example.Futurify.Model.Usuario;
import com.example.Futurify.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void delete(Integer id){
        usuarioRepository.deleteById(id);
    }

    public Usuario findById(Integer id){
        return usuarioRepository.findById(id).
                orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

}
