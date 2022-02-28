package com.vendas.vendas.Model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("vendas")
public class Vendas {
    @Id
    private String id;
    private List<String> produto;
    private String data;
    private int quantProdutos;
    private float valorTotal;

    
    public Vendas(List<String> produto, String data, int quantProdutos, float valorTotal) {
        this.produto = produto;
        this.data = data;
        this.quantProdutos = quantProdutos;
        this.valorTotal = valorTotal;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getProduto() {
        return produto;
    }

    public void setProduto(List<String> produto) {
        this.produto = produto;
    }

    public int getQuantProdutos() {
        return quantProdutos;
    }

    public void setQuantProdutos(int quantProdutos) {
        this.quantProdutos = quantProdutos;
    }

    public float getValorTotal() {
        return valorTotal;
    }
    
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String dataAtual) {
        this.data = dataAtual;
    }

    public void setData(LocalDate dataAtual) {
    }  
    
}
