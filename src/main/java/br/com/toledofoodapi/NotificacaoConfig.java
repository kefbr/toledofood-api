package br.com.toledofoodapi;

import br.com.toledofoodapi.di.notificacao.NotificadorEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoConfig {
    @Bean
    public NotificadorEmail notificadorEmail(){
        NotificadorEmail notificador = new NotificadorEmail("smtp.toledo.com.br");
        notificador.setCaixaAlta(true);
        return notificador;
    }
}
