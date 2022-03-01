package com.vendas.vendas.View.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.vendas.vendas.Model.Vendas;
import com.vendas.vendas.Service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException.FeignClientException;

@RestController
@RequestMapping("api/vendas")
public class VendasController {
    
    @Autowired
    private VendaService servico;

    @Autowired
    private VendaFeignClient vendaFeignClient;

    private LocalDate dataAtual = LocalDate.now();

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody Vendas venda) {
        List<String> vendaId = venda.getProduto();

        for (String id : vendaId) {
            try {
                if (vendaFeignClient.obterPorId(id) == null) {
                    return new ResponseEntity<>("Produto Não encontrado.", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            catch (FeignClientException e) {
                if (e.status() == 404) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                else {
                    throw e;
                }                
            }
        }

        venda.setData(dataAtual);
        
        Vendas vendaEfetuado = servico.add(venda);
        
        return new ResponseEntity<>(vendaEfetuado, HttpStatus.CREATED);
    }

    @GetMapping ("/{id}")
    public ResponseEntity obterPorId(@PathVariable String id){
        Optional<Vendas> venda = servico.get(id);
        if (venda.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Vendas>> obterTodasVendas(){
        List<Vendas> venda = servico.obterTodasVendas();

        if (venda.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(venda, HttpStatus.OK);
    }
}
