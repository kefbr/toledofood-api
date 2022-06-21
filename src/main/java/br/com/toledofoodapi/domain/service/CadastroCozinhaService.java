package br.com.toledofoodapi.domain.service;

import br.com.toledofoodapi.domain.excetion.EntidadeEmUsoException;
import br.com.toledofoodapi.domain.excetion.EntidadeNaoEncontradaException;
import br.com.toledofoodapi.domain.model.Cozinha;
import br.com.toledofoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.salvar(cozinha);
    }

    public void excluir(Long cozinhaId){
        try {
            cozinhaRepository.remover(cozinhaId);
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
        }

    }

}
