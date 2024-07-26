package com.example.srv_listagem_produtos.repository;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.model.FornecedorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
//    void delete(FornecedorDTO fornecedor);

//    FornecedorEntity findById(Long idFornecedor);
}
