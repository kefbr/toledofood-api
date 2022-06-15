package br.com.toledofoodapi.domain.repository;

import br.com.toledofoodapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> todas();
    Restaurante porId(Long id);
    Restaurante adicionar(Restaurante restaurante);
    void remover(Restaurante restaurante);

}
