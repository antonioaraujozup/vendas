package br.com.zup.edu.vendas.api.controller;

import br.com.zup.edu.vendas.api.model.Pedido;
import br.com.zup.edu.vendas.api.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
public class RemoverPedidoController {

    private final PedidoRepository repository;

    public RemoverPedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        Pedido pedido = repository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado");
        });

        repository.delete(pedido);

        return ResponseEntity.noContent().build();
    }
}
