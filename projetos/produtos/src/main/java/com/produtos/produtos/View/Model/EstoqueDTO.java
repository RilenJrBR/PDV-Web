package com.produtos.produtos.View.Model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class EstoqueDTO {
    @Id
    //@NotBlank(message = "Voce deve prencher o id!!")
    private String id;
    private Integer estoque;

    public EstoqueDTO(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
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
