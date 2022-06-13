package br.com.toledofoodapi.di.notificacao;

import br.com.toledofoodapi.di.modelo.Cliente;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Setter
@Component
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Profile("dev")
public class NotificadorEmailMock implements Notificador {
    private String hostServidorSmtp;

    @Override
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("MOCK: Notificando %s através do e-mail %s usando STMP %s: %s %n",
                cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, mensagem);
    }
}
