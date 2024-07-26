package com.example.srv_listagem_produtos.service.impl;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.entity.ProdutosEntity;
import com.example.srv_listagem_produtos.excepetion.FornecedorNotFoundException;
import com.example.srv_listagem_produtos.mapper.ProdutosMapper;
import com.example.srv_listagem_produtos.model.CadastrarProdutoRequest;
import com.example.srv_listagem_produtos.model.ProdutosDTO;
import com.example.srv_listagem_produtos.repository.ProdutosRepository;
import com.example.srv_listagem_produtos.service.ProdutosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProdutosServiceImpl implements ProdutosService {

    private ProdutosRepository produtosRepository;
    private final ProdutosMapper produtosMapper;

    @Override
    public ProdutosEntity cadastrarProduto(CadastrarProdutoRequest produtos) {
        ProdutosEntity produtosEntity = produtosMapper.toProdutosRequest(produtos);
        return this.produtosRepository.save(produtosEntity);
    }

    @Override
    public List<ProdutosEntity> listarProdutos() {
        return this.produtosRepository.findAll();
    }

    @Override
    public ProdutosEntity atualizarProduto(ProdutosEntity produtosEntity) {
        return this.produtosRepository.save(produtosEntity);
    }

    @Override
    public void excluirProduto(ProdutosEntity produtosEntity) {
        this.produtosRepository.delete(produtosEntity);
    }

    @Override
    public ProdutosEntity obterProdutoById(Long idProdutos) {
        return this.produtosRepository.findById(idProdutos).orElseThrow(FornecedorNotFoundException::new);
    }

    @Override
    public List<ProdutosEntity> obterProdutosByIdFornecedor(FornecedorEntity fornecedorEntity) {
      return this.produtosRepository.findAllByFornecedor(fornecedorEntity);
    }
}
