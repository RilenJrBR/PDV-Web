package com.vendas.vendas.View.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.vendas.vendas.Model.Vendas;
import com.vendas.vendas.Service.VendaService;
import com.vendas.vendas.View.Model.VendasDTO;

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
    public ResponseEntity<VendasDTO> criarVenda(@RequestBody @Valid VendasDTO dto){
        Vendas venda = Vendas.from(dto);
        venda = servico.add(venda);
        return new ResponseEntity<>(VendasDTO.from(venda), HttpStatus.CREATED);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<VendasDTO> obterPorId(@PathVariable String id){
        Optional<Vendas> venda = servico.get(id);
        if (venda.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(VendasDTO.from(venda.get()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VendasDTO>> obterTodasVendas(@RequestBody VendasDTO dto){
        List<Vendas> venda = servico.obterTodasVendas();

        List<VendasDTO> dtos = venda

        .stream()
        .map(VendasDTO::from)
        .collect(Collectors.toList());

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarVenda(@PathVariable String id){
        servico.deletarVenda(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
