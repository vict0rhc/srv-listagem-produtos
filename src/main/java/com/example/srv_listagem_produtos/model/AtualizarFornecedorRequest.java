package com.example.srv_listagem_produtos.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "DTO para atualizar os dados de um fornecedor")
public class AtualizarFornecedorRequest {

    @ApiModelProperty(value = "Nome do Fornecedor, campo obrigatório", required = true, example = "Roberto da silva", position = 0)
    private String nome;

    @ApiModelProperty(value = "Código do pais, campo obrigatório", required = true, example = "Brasil", position = 1)
    private String codigoPais;
}
