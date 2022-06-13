package br.com.toledofoodapi.di.service;

import br.com.toledofoodapi.di.modelo.Cliente;
import br.com.toledofoodapi.di.notificacao.NivelUrgencia;
import br.com.toledofoodapi.di.notificacao.Notificador;
import br.com.toledofoodapi.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class AtivacaoClienteService {
    @Autowired
    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    private Notificador notificador;

    public void ativar(Cliente cliente){
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro está ativo com sucesso.");
    }
}
