package br.com.toledofoodapi.di.service;

import br.com.toledofoodapi.di.modelo.Cliente;
import br.com.toledofoodapi.di.notificacao.Notificador;

public class AtivacaoClienteService {
    private final Notificador notificador;
    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void ativar(Cliente cliente){
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro está ativo com sucesso.");
    }
}
