package br.com.toledofoodapi.di.service;

import br.com.toledofoodapi.di.modelo.Cliente;
import br.com.toledofoodapi.di.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {
    private NotificadorEmail notificador;

    public void ativar(Cliente cliente){
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro está ativo com sucesso.");
    }
}
