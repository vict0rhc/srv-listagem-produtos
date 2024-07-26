package com.example.srv_listagem_produtos.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "DTO para representar um fornecedor")
public class FornecedorDTO {

    @ApiModelProperty(value = "Nome do Fornecedor, campo obrigatório", required = true, example = "Roberto da silva", position = 0)
    private String nome;

    @ApiModelProperty(value = "Código do pais, campo obrigatório", required = true, example = "Brasil", position = 1)
    private String codigoPais;

    @ApiModelProperty(value = "Lista de produtos, campo obrigatorio", required = true,position = 2)
    private Set<ProdutosDTO> produtos;
}
