package br.com.toledofoodapi.di.service;

import br.com.toledofoodapi.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    public void ativar(Cliente cliente){
        cliente.ativar();
        applicationEventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }
}
