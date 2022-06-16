package br.com.toledofoodapi.domain.repository;

import br.com.toledofoodapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha adicionar(Cozinha cozinha);
    void remover(Cozinha cozinha);

}
