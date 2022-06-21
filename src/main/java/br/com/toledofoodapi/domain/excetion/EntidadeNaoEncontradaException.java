package br.com.toledofoodapi.domain.excetion;

import java.io.Serial;

public class EntidadeNaoEncontradaException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
