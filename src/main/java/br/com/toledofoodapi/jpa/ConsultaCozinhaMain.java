package br.com.toledofoodapi.jpa;

import br.com.toledofoodapi.ToledofoodApiApplication;
import br.com.toledofoodapi.domain.model.Cozinha;
import br.com.toledofoodapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String [] args){
        ApplicationContext applicationContext = new SpringApplicationBuilder(ToledofoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        List<Cozinha> cozinhaList = cozinhaRepository.listar();
        for (Cozinha cozinha:cozinhaList) {
            System.out.println(cozinha.getNome());
        }
    }
}
