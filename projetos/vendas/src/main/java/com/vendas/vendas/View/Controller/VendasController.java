package com.vendas.vendas.View.Controller;

import java.util.List;

import com.vendas.vendas.Model.Vendas;
import com.vendas.vendas.Service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vendas")
public class VendasController {
    
    @Autowired
    private VendaService servico;

    @PostMapping
    public ResponseEntity<Vendas> criarVenda(@RequestBody Vendas venda){
        Vendas vendaCriada = servico.salvar(venda);
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Vendas>> obterVendas(){
        List<Vendas> venda = servico.obterVendas();
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarVenda(@PathVariable String id){
        servico.deletarVenda(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
