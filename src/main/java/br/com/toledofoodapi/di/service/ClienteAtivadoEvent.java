package br.com.toledofoodapi.di.service;

import br.com.toledofoodapi.di.modelo.Cliente;
import lombok.Getter;

@Getter
public class ClienteAtivadoEvent {

    private final Cliente cliente;

    public ClienteAtivadoEvent(Cliente cliente) {
        this.cliente = cliente;
    }
}
