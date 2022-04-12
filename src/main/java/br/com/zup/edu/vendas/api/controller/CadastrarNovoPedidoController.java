package br.com.zup.edu.vendas.api.controller;

import br.com.zup.edu.vendas.api.model.Pedido;
import br.com.zup.edu.vendas.api.repository.PedidoRepository;
import br.com.zup.edu.vendas.api.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovoPedidoController {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public CadastrarNovoPedidoController(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    @PostMapping("/pedidos")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PedidoRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Pedido novoPedido = request.paraPedido(produtoRepository);

        pedidoRepository.save(novoPedido);

        URI location = uriComponentsBuilder.path("/pedidos/{id}")
                .buildAndExpand(novoPedido.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
