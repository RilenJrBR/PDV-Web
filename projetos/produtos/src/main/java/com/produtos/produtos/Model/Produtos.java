package com.produtos.produtos.Model;

import com.produtos.produtos.View.Model.ProdutosDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("produtos")
public class Produtos {
    @Id
    private String id;
    private String nome;
    private Integer estoque;
    private float valor;
    
    public Produtos(String nome, Integer estoque, float valor) {
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
    public Integer getEstoque() {
        return estoque;
    }
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }        

    public static Produtos from(ProdutosDTO dto) {
        return new Produtos(dto.getNome(), dto.getEstoque(), dto.getValor());
    }
}
