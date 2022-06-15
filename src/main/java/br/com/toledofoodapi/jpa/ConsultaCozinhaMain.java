package br.com.toledofoodapi.jpa;

import br.com.toledofoodapi.ToledofoodApiApplication;
import br.com.toledofoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String [] args){
        ApplicationContext applicationContext = new SpringApplicationBuilder(ToledofoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        List<Cozinha> cozinhaList = cadastroCozinha.listar();
        for (Cozinha cozinha:cozinhaList) {
            System.out.println(cozinha.getNome());
        }
    }
}
