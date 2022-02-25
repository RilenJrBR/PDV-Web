package com.produtos.produtos.View.Handler;

import java.util.List;

public class BadRequestDTO {
    private List<String> erros;

    public BadRequestDTO(List<String> erros) {
        this.erros = erros;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
