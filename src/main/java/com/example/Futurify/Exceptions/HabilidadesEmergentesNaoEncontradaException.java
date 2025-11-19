package com.example.Futurify.Exceptions;

public class HabilidadesEmergentesNaoEncontradaException extends RuntimeException{

    public HabilidadesEmergentesNaoEncontradaException(Integer id){
        super("Habilidade emergente com ID " + id + " nao encotrada.");
    }
}
