package com.example.srv_listagem_produtos.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "DTO para Cadastrar um produto")
public class CadastrarProdutoRequest {

    @ApiModelProperty(value = "nome do produto, campo obrigatório", required = true, example = "Nimbus 2000", position = 0)
    private String nome;

    @ApiModelProperty(value = "descricao do produto, campo obrigatorio", required = true, example = "vassoura voadora", position = 1)
    private String descricao;

    @ApiModelProperty(value = "preço do produto, campo obrigatório",required = true, example = "R$1000", position = 2)
    private String preco;

    @ApiModelProperty(value = "quantidade deste produto disponível, campo obrigatório", required = true, example = "15", position = 3)
    private int quantidade;

    @ApiModelProperty(value = "id do fornecedor do produto, campo obrigatório", required = true, example = "joao", position = 4)
    private Long idFornecedor;

    @ApiModelProperty(value = "categoria do produto, campo obrigatorio", required = true, example = "Artefatos mágicos", position = 5)
    private String categoria;

}
