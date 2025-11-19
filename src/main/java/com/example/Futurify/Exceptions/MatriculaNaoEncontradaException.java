package com.example.Futurify.Exceptions;

public class MatriculaNaoEncontradaException extends RuntimeException{

    public MatriculaNaoEncontradaException(Integer id) {
        super("Matrícula com ID " + id + " não encontrada.");
    }
}
