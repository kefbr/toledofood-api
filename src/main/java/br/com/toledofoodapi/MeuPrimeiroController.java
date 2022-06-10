package br.com.toledofoodapi;

import br.com.toledofoodapi.di.modelo.Cliente;
import br.com.toledofoodapi.di.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    private final AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        Cliente joao = new Cliente("João", "joao@xyz.com","34999998888", false);
        ativacaoClienteService.ativar(joao);
        return "Hello!";
    }

}
