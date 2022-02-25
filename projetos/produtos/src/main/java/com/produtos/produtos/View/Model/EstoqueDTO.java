package com.produtos.produtos.View.Model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class EstoqueDTO {
    @Id
    @NotBlank(message = "Voce deve prencher o id!!")
    private String id;
    private int estoque;

    public EstoqueDTO(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }   
    public static EstoqueDTO from(ProdutosDTO produto) {
        return new EstoqueDTO(produto.getEstoque());
    } 
}
