package br.com.toledofoodapi.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Setter
@Getter
@Table(name = "tab_cozinhas")
@Entity
public class Cozinha {

    @Id
    private Long id;
    @Column(name = "nom_cozinha")
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cozinha cozinha = (Cozinha) o;
        return id != null && Objects.equals(id, cozinha.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
