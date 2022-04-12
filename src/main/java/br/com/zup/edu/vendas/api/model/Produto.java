package br.com.zup.edu.vendas.api.model;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Produto() {
    }

    public Produto(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }
}
