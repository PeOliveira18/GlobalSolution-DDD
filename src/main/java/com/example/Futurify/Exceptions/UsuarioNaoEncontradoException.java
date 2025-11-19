package com.example.Futurify.Exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{

    public UsuarioNaoEncontradoException(Integer id) {
        super("Usuário com ID " + id + " não encontrado.");
    }
}
