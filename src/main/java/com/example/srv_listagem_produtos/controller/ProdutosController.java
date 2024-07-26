package com.example.srv_listagem_produtos.controller;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.entity.ProdutosEntity;
import com.example.srv_listagem_produtos.model.AtualizarFornecedorRequest;
import com.example.srv_listagem_produtos.model.CadastrarProdutoRequest;
import com.example.srv_listagem_produtos.model.FornecedorDTO;
import com.example.srv_listagem_produtos.model.ProdutosDTO;
import com.example.srv_listagem_produtos.service.FornecedorService;
import com.example.srv_listagem_produtos.service.ProdutosService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProdutosController {

    @Autowired
    ProdutosService service;

    @Autowired
    FornecedorService fornecedorService;

    private final ModelMapper modelMapper;
    @GetMapping(value = "/listar-produtos")
    @Operation(summary = "Listar todos os produtos")
    public ResponseEntity<List<ProdutosEntity>> listarProdutos(){
        return new ResponseEntity<>(this.service.listarProdutos(), HttpStatus.OK);
    }
    @PostMapping(value = "/cadastrar-produto", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ProdutosEntity> cadastrarProduto(
            @ApiParam(value = "Conjunto de dados para cadastrar produtos", required = true)
            @Validated
            @RequestBody CadastrarProdutoRequest cadastrarProdutoRequest){
        return ResponseEntity.accepted().body(service.cadastrarProduto(cadastrarProdutoRequest));
    }
    @DeleteMapping(value = "{id}/deletar-produto")
    @Operation(summary = "Deletar produto")
    public ResponseEntity<ProdutosEntity> excluirProdutos(@PathVariable Long id){
        ProdutosEntity produtosEntity =  this.service.obterProdutoById(id);
        this.service.excluirProduto(produtosEntity);
        return new ResponseEntity<>(produtosEntity, HttpStatus.OK);
    }

    @PutMapping(value = "{id}/atualizar-produto")
    @Operation(summary = "Atualizar dados do produto")
    public ResponseEntity<ProdutosEntity> atualizarProduto(
            @PathVariable Long id,
            @Valid
            @RequestBody ProdutosDTO produtosDTO){
        ProdutosEntity produtosEntity = this.service.obterProdutoById(id);
        modelMapper.map(produtosDTO,produtosEntity);
        produtosEntity = this.service.atualizarProduto(produtosEntity);
        return new ResponseEntity<>(produtosEntity, HttpStatus.OK);

    }

    @GetMapping(path = "{id}/listar-produtos-por-fornecedor")
    @Operation(summary = "Listar produtos por fornecedor")
    public ResponseEntity<List<ProdutosEntity>> listarProdutosPorFornecedor(@PathVariable Long id) {
        FornecedorEntity fornecedor = this.fornecedorService.obterFornecedorById(id);
        return new ResponseEntity<>(this.service.obterProdutosByIdFornecedor(fornecedor), HttpStatus.OK);
    }


}
