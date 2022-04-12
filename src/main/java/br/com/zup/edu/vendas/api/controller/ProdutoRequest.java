package br.com.zup.edu.vendas.api.controller;

import br.com.zup.edu.vendas.api.model.Produto;

import javax.validation.constraints.NotBlank;

public class ProdutoRequest {

    @NotBlank
    private String titulo;

    public ProdutoRequest() {
    }

    public Produto paraProduto() {
        return new Produto(titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
