package com.example.Futurify.Exceptions;

public class TrilhaNaoEncontradaException extends RuntimeException{

    public TrilhaNaoEncontradaException(Integer id) {
        super("Trilha com ID " + id + " não encontrada.");
    }
}
