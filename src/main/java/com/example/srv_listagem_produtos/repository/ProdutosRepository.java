package com.example.srv_listagem_produtos.repository;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutosRepository  extends JpaRepository<ProdutosEntity, Long> {
    List<ProdutosEntity> findAllByFornecedor(FornecedorEntity fornecedor);
}
