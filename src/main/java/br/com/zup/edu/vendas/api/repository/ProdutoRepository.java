package br.com.zup.edu.vendas.api.repository;

import br.com.zup.edu.vendas.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
