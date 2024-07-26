package com.example.srv_listagem_produtos.excepetion;

import jakarta.persistence.EntityNotFoundException;

public class ProdutosNotFoundException extends EntityNotFoundException {
    public ProdutosNotFoundException() {
        super("Produto não encontrado");
    }
}
