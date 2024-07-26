package com.example.srv_listagem_produtos.service;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.model.FornecedorDTO;

import java.util.List;

public interface FornecedorService {

    FornecedorEntity cadastrarFornecedor(FornecedorDTO fornecedor);

    FornecedorEntity atualizarFornecedor(FornecedorEntity fornecedor);

    List<FornecedorEntity> listarFornecedor();

    void excluirFornecedor(FornecedorEntity fornecedor);

    FornecedorEntity obterFornecedorById(Long idFornecedor);


}
