package com.example.Futurify.Exceptions;

public class CompetenciaNaoEncontradaException extends RuntimeException{

    public CompetenciaNaoEncontradaException(Integer id) {
        super("Competencia com ID " + id + " não encontrada.");
    }
}
