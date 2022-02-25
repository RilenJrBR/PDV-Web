package com.produtos.produtos.View.Model;

import javax.validation.constraints.NotBlank;

import com.produtos.produtos.Model.Produtos;

import org.springframework.data.annotation.Id;

public class ProdutosDTO {
    @Id
    private String id;
    private String nome;
    @NotBlank(message = "Voce deve prencher a quantidade em estoque!!")
    private int estoque;
    private float valor;
    
    public ProdutosDTO(String nome, int estoque, float valor) {
        this.nome = nome;
        this.estoque = estoque;
        this.valor = valor;
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
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }    
    
    public static ProdutosDTO from(Produtos produto) {
        return new ProdutosDTO(produto.getNome(), produto.getEstoque(), produto.getValor());
    }
}
