package br.com.zup.edu.vendas.api.repository;

import br.com.zup.edu.vendas.api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
