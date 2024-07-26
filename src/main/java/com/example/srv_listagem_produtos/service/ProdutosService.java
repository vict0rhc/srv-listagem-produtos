package com.example.srv_listagem_produtos.service;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.entity.ProdutosEntity;
import com.example.srv_listagem_produtos.model.CadastrarProdutoRequest;
import com.example.srv_listagem_produtos.model.ProdutosDTO;

import java.util.List;

public interface ProdutosService   {

    ProdutosEntity cadastrarProduto(CadastrarProdutoRequest produtos);

    List<ProdutosEntity> listarProdutos();

    ProdutosEntity atualizarProduto(ProdutosEntity produtosEntity);

    void excluirProduto(ProdutosEntity produtosEntity);

    ProdutosEntity obterProdutoById(Long idProdutos);

    List<ProdutosEntity> obterProdutosByIdFornecedor(FornecedorEntity fornecedorEntity);

}
