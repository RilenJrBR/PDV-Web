package com.produtos.produtos.View.Model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class EstoqueDTO {
    @Id
    @NotBlank(message = "Voce deve prencher o id!!")
    private String id;
    private int quantEstoque;

    public EstoqueDTO(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }   
    public static EstoqueDTO from(ProdutosDTO produto) {
        return new EstoqueDTO(produto.getQuantEstoque());
    } 
}
