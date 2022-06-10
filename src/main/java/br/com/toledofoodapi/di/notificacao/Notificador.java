package br.com.toledofoodapi.di.notificacao;

import br.com.toledofoodapi.di.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
