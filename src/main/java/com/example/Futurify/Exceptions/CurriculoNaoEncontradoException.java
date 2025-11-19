package com.example.Futurify.Exceptions;

public class CurriculoNaoEncontradoException extends RuntimeException{

    public CurriculoNaoEncontradoException(Integer id){
        super("Curriculo com ID " + id + " nao encontrado.");
    }
}
