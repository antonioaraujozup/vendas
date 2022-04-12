package br.com.zup.edu.vendas.api.model;

import javax.persistence.*;

@Entity
public class ItemDePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public ItemDePedido() {
    }

    public ItemDePedido(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
