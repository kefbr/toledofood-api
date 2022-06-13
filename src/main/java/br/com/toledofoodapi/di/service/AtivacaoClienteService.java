package br.com.toledofoodapi.di.service;

import br.com.toledofoodapi.di.modelo.Cliente;
import br.com.toledofoodapi.di.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {
    @Autowired
    private List<Notificador> notificadores;

    public void ativar(Cliente cliente){
        cliente.ativar();
        for (Notificador notificador: notificadores) {
            notificador.notificar(cliente, "Seu cadastro está ativo com sucesso.");
        }
    }
}
