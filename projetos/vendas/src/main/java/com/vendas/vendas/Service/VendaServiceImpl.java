package com.vendas.vendas.Service;

import java.util.List;
import java.util.Optional;

import com.vendas.vendas.Model.Vendas;
import com.vendas.vendas.Repository.VendasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaServiceImpl implements VendaService {
    
    @Autowired
    private VendasRepository repositorio;

    @Override
    public Vendas add(Vendas vendas){
        return repositorio.save(vendas);
    }

    @Override
    public Optional<Vendas> get(String id){
        return repositorio.findById(id);
    }

    @Override
    public List<Vendas> obterTodasVendas(){
        return repositorio.findAll();
    }
}
