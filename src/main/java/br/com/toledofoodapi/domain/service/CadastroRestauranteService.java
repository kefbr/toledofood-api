package br.com.toledofoodapi.domain.service;

import br.com.toledofoodapi.domain.excetion.EntidadeNaoEncontradaException;
import br.com.toledofoodapi.domain.model.Cozinha;
import br.com.toledofoodapi.domain.model.Restaurante;
import br.com.toledofoodapi.domain.repository.CozinhaRepository;
import br.com.toledofoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar (Restaurante restaurante){
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
        if (cozinha == null){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d", cozinhaId)
            );
        }
        restaurante.setCozinha(cozinha);
        return restauranteRepository.salvar(restaurante);
    }

}
