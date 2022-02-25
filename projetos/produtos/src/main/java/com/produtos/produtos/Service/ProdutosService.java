package com.produtos.produtos.Service;

import java.util.List;
import java.util.Optional;

import com.produtos.produtos.Model.Produtos;

public interface ProdutosService {
    Produtos add(Produtos produto);
    Optional<Produtos> get(String id);
    List<Produtos> obterTodasProdutos();
    void deletarProduto(String id);
    Optional<Produtos> atualizarEstoque(String id);
}
