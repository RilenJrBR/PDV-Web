package com.produtos.produtos.View.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.produtos.produtos.Model.Produtos;
import com.produtos.produtos.Service.ProdutosService;
import com.produtos.produtos.View.Model.EstoqueDTO;
import com.produtos.produtos.View.Model.ProdutosDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosService servico;

    @PostMapping
    public ResponseEntity<ProdutosDTO> cadastrar(@RequestBody @Valid ProdutosDTO dto) {
        Produtos produto = Produtos.from(dto);
        produto = servico.add(produto);
        return new ResponseEntity<>(ProdutosDTO.from(produto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosDTO> obterPorId(@PathVariable String id) {
        Optional<Produtos> produto = servico.get(id);

        if (produto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ProdutosDTO.from(produto.get()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProdutosDTO>> obterTodasProdutos(@RequestBody ProdutosDTO dto){
        List<Produtos> produto = servico.obterTodasProdutos();

        List<ProdutosDTO> dtos = produto

            .stream()
            .map(ProdutosDTO::from)
            .collect(Collectors.toList());

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable String id){
        servico.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProdutosDTO> atualizarEstoque(@RequestBody @Valid EstoqueDTO dto, String id){

        Optional<Produtos> optinal = servico.get(id);

        if (optinal.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Produtos produto = optinal.get();
        produto.setEstoque(produto.getEstoque());
        produto = servico.add(produto);

        return new ResponseEntity<>(ProdutosDTO.from(produto), HttpStatus.OK);
    }
}
