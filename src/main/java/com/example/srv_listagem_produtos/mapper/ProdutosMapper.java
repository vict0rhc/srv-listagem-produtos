package com.example.srv_listagem_produtos.mapper;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.entity.ProdutosEntity;
import com.example.srv_listagem_produtos.model.CadastrarProdutoRequest;
import com.example.srv_listagem_produtos.model.FornecedorDTO;
import com.example.srv_listagem_produtos.model.ProdutosDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutosMapper {

    private final ModelMapper mapper;


    public ProdutosEntity toProdutos(ProdutosDTO produtosDTO){
        return mapper.map(produtosDTO, ProdutosEntity.class);

    }

    public ProdutosEntity toProdutosRequest(CadastrarProdutoRequest produtoRequest){
        return mapper.map(produtoRequest, ProdutosEntity.class);
    }

}
