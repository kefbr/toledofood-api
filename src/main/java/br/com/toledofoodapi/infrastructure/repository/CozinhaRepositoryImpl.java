package br.com.toledofoodapi.infrastructure.repository;

import br.com.toledofoodapi.domain.model.Cozinha;
import br.com.toledofoodapi.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cozinha> listar(){
        TypedQuery<Cozinha> query = entityManager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    @Override
    public Cozinha buscar(Long id){
        return entityManager.find(Cozinha.class,id);
    }

    @Transactional
    @Override
    public Cozinha adicionar(Cozinha cozinha){
        return entityManager.merge(cozinha);
    }

    @Transactional
    @Override
    public void remover (Cozinha cozinha){
        cozinha = buscar(cozinha.getId());
        entityManager.remove(cozinha);
    }
}
