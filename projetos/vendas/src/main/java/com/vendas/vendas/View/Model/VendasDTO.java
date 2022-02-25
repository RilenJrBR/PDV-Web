package com.vendas.vendas.View.Model;

import javax.validation.constraints.NotBlank;

import com.vendas.vendas.Model.Vendas;

import org.springframework.data.annotation.Id;

public class VendasDTO {
    @Id
    private String id;
    @NotBlank(message = "Você deve preencher com um codigo de produto valido!")
    private String produto;
    private int quantProdutos;
    private float valorUn;
    private float valorTotal;
    
    public VendasDTO(String produto, int quantProdutos, float valorUn, float valorTotal) {
        this.produto = produto;
        this.quantProdutos = quantProdutos;
        this.valorUn = valorUn;
        this.valorTotal = valorTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantProdutos() {
        return quantProdutos;
    }

    public void setQuantProdutos(int quantProdutos) {
        this.quantProdutos = quantProdutos;
    }

    public float getValorUn() {
        return valorUn;
    }

    public void setValorUn(float valorUn) {
        this.valorUn = valorUn;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static VendasDTO from(Vendas venda){
        return new VendasDTO(venda.getProduto(), venda.getQuantProdutos(), venda.getValorUn(), 
        venda.getValorTotal());
    }
}
