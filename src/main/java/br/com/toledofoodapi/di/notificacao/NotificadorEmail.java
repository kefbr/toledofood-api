package br.com.toledofoodapi.di.notificacao;

import br.com.toledofoodapi.di.modelo.Cliente;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Component
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
public class NotificadorEmail implements Notificador {
    @Autowired
    private NotificadorProperties notificadorProperties;
    @Override
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("Notificando %s através do e-mail %s usando STMP %s: %s %n",
                cliente.getNome(), cliente.getEmail(),
                notificadorProperties.getHostServidor()+":"+notificadorProperties.getPortaServidor(),
                mensagem);
    }
}
