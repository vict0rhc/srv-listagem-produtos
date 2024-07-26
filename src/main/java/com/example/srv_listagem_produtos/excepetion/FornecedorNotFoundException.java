package com.example.srv_listagem_produtos.excepetion;

import jakarta.persistence.EntityNotFoundException;

public class FornecedorNotFoundException extends EntityNotFoundException {
    public FornecedorNotFoundException() {
        super("Fornecedor não encontrado");
    }
}
