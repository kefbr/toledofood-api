package br.com.toledofoodapi.di.notificacao;

import br.com.toledofoodapi.di.modelo.Cliente;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class NotificadorEmail implements Notificador {
    private boolean caixaAlta;
    private String hostServidorSmtp;

    @Override
    public void notificar(Cliente cliente, String mensagem){
        if(this.caixaAlta){
            mensagem = mensagem.toUpperCase();
        }
        System.out.printf("Notificando %s através do e-mail %s usando STMP %s: %s\n",
                cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, mensagem);
    }
}
