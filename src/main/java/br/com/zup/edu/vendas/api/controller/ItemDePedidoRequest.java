package br.com.zup.edu.vendas.api.controller;

import br.com.zup.edu.vendas.api.model.ItemDePedido;
import br.com.zup.edu.vendas.api.model.Produto;
import br.com.zup.edu.vendas.api.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemDePedidoRequest {

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    private Long produtoId;

    public ItemDePedidoRequest() {
    }

    public ItemDePedido paraItemDePedido(ProdutoRepository produtoRepository) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        });

        ItemDePedido itemDePedido = new ItemDePedido(quantidade,produto);

        return itemDePedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}
