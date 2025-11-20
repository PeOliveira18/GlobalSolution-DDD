package com.example.Futurify.Exceptions;

public class ProgressoTrilhaNaoEncontradaException extends RuntimeException {

    public ProgressoTrilhaNaoEncontradaException(Integer id){
        super("Progresso de trilha com ID " + " nao encontrado.");
    }
}
