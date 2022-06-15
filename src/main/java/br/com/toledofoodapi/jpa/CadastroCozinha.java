package br.com.toledofoodapi.jpa;

import br.com.toledofoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cozinha> listar(){
        TypedQuery<Cozinha> query = entityManager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    public Cozinha buscar(Long id){
        return entityManager.find(Cozinha.class,id);
    }

    @Transactional
    public Cozinha salvar(Cozinha cozinha){
        return entityManager.merge(cozinha);
    }

    @Transactional
    public void remover (Cozinha cozinha){
        cozinha = buscar(cozinha.getId());
        entityManager.remove(cozinha);
    }
}
