package com.example.srv_listagem_produtos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_produtos")
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = true)
    private String nome;

    @Column(name = "descricao",nullable = true)
    private String descricao;

    @Column(name = "preco",nullable = true)
    private String preco;

    @Column(name = "quantidade",nullable = true)
    private int quantidade;

    @Column(name = "categoria",nullable = true)
    private String categoria;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fornecedor_id", nullable = true)
    private FornecedorEntity fornecedor;

    @CreationTimestamp
    @Column(nullable = true)
    private LocalDate dataCriacao;

    @PrePersist
    protected void onCreate(){
        this.dataCriacao = LocalDate.now();
    }






}
