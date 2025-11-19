package com.example.Futurify.Exceptions;

public class AnaliseCurriculoNaoEncontradoException extends RuntimeException{

    public AnaliseCurriculoNaoEncontradoException(Integer id) {
        super("Analise de curriculo com ID " + id + " não encontrada.");
    }
}
