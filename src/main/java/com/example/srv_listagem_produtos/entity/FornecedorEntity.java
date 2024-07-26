package com.example.srv_listagem_produtos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_fornecedor")
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable =true)
    private String nome;

    @Column(name = "codigoPais",nullable = true)
    private String codigoPais;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JsonIgnore
    private Set<ProdutosEntity> produtos;

}
