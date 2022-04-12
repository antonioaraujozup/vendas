package br.com.zup.edu.vendas.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private BigDecimal total;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "pedido")
    private List<ItemDePedido> itens = new ArrayList<>();

    /**
     * @deprecated Construtor exclusivo para uso do Hibernate.
     */
    @Deprecated
    public Pedido() {
    }

    public Pedido(String numero, BigDecimal total) {
        this.numero = numero;
        this.total = total;
    }

    public void adicionaItens(List<ItemDePedido> itensPedido) {
        itensPedido.forEach(item -> item.setPedido(this));

        this.itens.addAll(itensPedido);
    }

    public Long getId() {
        return id;
    }
}
