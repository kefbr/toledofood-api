package br.com.toledofoodapi.di.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private boolean ativo = false;

    public void ativar(){
        this.ativo = true;
    }
}
