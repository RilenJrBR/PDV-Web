package com.produtos.produtos.View.Model;

import javax.validation.constraints.NotBlank;

import com.produtos.produtos.Model.Produtos;

import org.springframework.data.annotation.Id;

public class ProdutosDTO {
    @Id
    @NotBlank(message = "Voce deve prencher o id!!")
    private String id;
    private String nome;
    private int quantEstoque;
    private float valorUn;
    
    public ProdutosDTO(String nome, int quantEstoque, float valorUn) {
        this.nome = nome;
        this.quantEstoque = quantEstoque;
        this.valorUn = valorUn;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantEstoque() {
        return quantEstoque;
    }
    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }
    public float getValorUn() {
        return valorUn;
    }
    public void setValorUn(float valorUn) {
        this.valorUn = valorUn;
    }    
    
    public static ProdutosDTO from(Produtos produto) {
        return new ProdutosDTO(produto.getNome(), produto.getQuantEstoque(), produto.getValorUn());
    }
}
