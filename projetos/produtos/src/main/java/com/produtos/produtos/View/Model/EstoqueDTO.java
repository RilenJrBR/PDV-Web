package com.produtos.produtos.View.Model;

import org.springframework.data.annotation.Id;

public class EstoqueDTO {
    @Id
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
}
