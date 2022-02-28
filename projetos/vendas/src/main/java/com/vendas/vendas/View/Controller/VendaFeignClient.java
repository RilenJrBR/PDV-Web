package com.vendas.vendas.View.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produto", fallback = VendaFeignClientFallback.class)
public interface VendaFeignClient {
    @GetMapping("/{id}")
    ProdutoDTO obterPorId(@PathVariable("id") String id);
}

@Component
class VendaFeignClientFallback implements VendaFeignClient {
    @Override
    public ResponseEntity<Object> obterPorId(String id) {
        return null;
    }
}
