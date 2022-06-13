package br.com.toledofoodapi.di.notificacao;

import br.com.toledofoodapi.di.modelo.Cliente;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("Notificando %s por SMS atráves do telefone %s: %s %n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
