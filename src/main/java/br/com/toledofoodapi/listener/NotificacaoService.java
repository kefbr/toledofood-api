package br.com.toledofoodapi.listener;

import br.com.toledofoodapi.di.notificacao.NivelUrgencia;
import br.com.toledofoodapi.di.notificacao.Notificador;
import br.com.toledofoodapi.di.notificacao.TipoDoNotificador;
import br.com.toledofoodapi.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @Autowired
    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    private Notificador notificador;
    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo.");
    }
}
