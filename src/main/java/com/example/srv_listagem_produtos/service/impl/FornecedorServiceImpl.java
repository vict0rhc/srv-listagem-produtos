package com.example.srv_listagem_produtos.service.impl;

import com.example.srv_listagem_produtos.client.controller.ApiDadosPaisesController;
import com.example.srv_listagem_produtos.client.model.ResponseApiDadosPaises;
import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.entity.ProdutosEntity;
import com.example.srv_listagem_produtos.excepetion.FornecedorNotFoundException;
import com.example.srv_listagem_produtos.mapper.FornecedorMapper;
import com.example.srv_listagem_produtos.mapper.ProdutosMapper;
import com.example.srv_listagem_produtos.model.FornecedorDTO;
import com.example.srv_listagem_produtos.repository.FornecedorRepository;
import com.example.srv_listagem_produtos.repository.ProdutosRepository;
import com.example.srv_listagem_produtos.service.FornecedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FornecedorServiceImpl implements FornecedorService {

    private final FornecedorMapper fornecedorMapper;
    private final ProdutosMapper produtosMapper;

    private FornecedorRepository fornecedorRepository;
    private ProdutosRepository produtosRepository;

    private ApiDadosPaisesController apiDadosPaisesController;


    @Override
    public FornecedorEntity cadastrarFornecedor(FornecedorDTO fornecedor) {
        FornecedorEntity fornecedorEntity = fornecedorMapper.toFornecedor(fornecedor);
        ResponseApiDadosPaises[] responseApiDadosPaises = apiDadosPaisesController.consultaApiDadosPaises(fornecedor.getCodigoPais());
        fornecedorEntity.setCodigoPais(Arrays.stream(responseApiDadosPaises).findAny().get().getCioc());
        this.fornecedorRepository.save(fornecedorEntity);
        Set<ProdutosEntity> produtos = fornecedor.getProdutos()
                .stream()
                .map(produtosMapper::toProdutos).collect(Collectors.toSet());
         produtos = produtos
                 .stream()
                 .peek(produto -> produto.setFornecedor(fornecedorEntity)).collect(Collectors.toSet());
         this.produtosRepository.saveAll(produtos);
         fornecedorEntity.setProdutos(produtos);

        return fornecedorEntity;
    }

    @Override
    public FornecedorEntity atualizarFornecedor(FornecedorEntity fornecedor) {
        return this.fornecedorRepository.save(fornecedor);
    }

    @Override
    public List<FornecedorEntity> listarFornecedor() {

        return this.fornecedorRepository.findAll();
    }

    @Override
    public void excluirFornecedor(FornecedorEntity fornecedor) {
        this.fornecedorRepository.delete(fornecedor);
    }

    @Override
    public FornecedorEntity obterFornecedorById(Long idFornecedor) {
        return this.fornecedorRepository.findById(idFornecedor).orElseThrow(FornecedorNotFoundException::new);
    }


}
