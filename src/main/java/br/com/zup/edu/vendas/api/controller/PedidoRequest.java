package br.com.zup.edu.vendas.api.controller;

import br.com.zup.edu.vendas.api.model.ItemDePedido;
import br.com.zup.edu.vendas.api.model.Pedido;
import br.com.zup.edu.vendas.api.repository.ProdutoRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoRequest {

    @NotBlank
    private String numero;

    @NotNull
    @Positive
    private BigDecimal total;

    @NotEmpty
    private List<@Valid ItemDePedidoRequest> itens;

    public PedidoRequest() {
    }

    public Pedido paraPedido(ProdutoRepository produtoRepository) {
        Pedido pedido = new Pedido(numero,total);

        List<ItemDePedido> itensDePedido = itens.stream()
                .map(i -> i.paraItemDePedido(produtoRepository))
                .collect(Collectors.toList());

        pedido.adicionaItens(itensDePedido);

        return pedido;
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemDePedidoRequest> getItens() {
        return itens;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setItens(List<ItemDePedidoRequest> itens) {
        this.itens = itens;
    }
}
