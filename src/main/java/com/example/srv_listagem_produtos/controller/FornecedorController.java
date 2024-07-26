package com.example.srv_listagem_produtos.controller;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.model.AtualizarFornecedorRequest;
import com.example.srv_listagem_produtos.model.FornecedorDTO;
import com.example.srv_listagem_produtos.service.FornecedorService;
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
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    private final ModelMapper modelMapper;

    @PostMapping(value = "/cadastrar-fornecedor", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<FornecedorEntity> cadastrarDadosFornecedor(
            @ApiParam(value = "Conjunto de dados para cadastrar fornecedor", required = true)
            @Validated
            @RequestBody FornecedorDTO fornecedorDTO){
            return ResponseEntity.accepted().body(service.cadastrarFornecedor(fornecedorDTO));
    }

    @GetMapping(value = "/listar-fornecedor")
    @Operation(summary = "Listar todos os fornecedores")
    public ResponseEntity<List<FornecedorEntity>> listarDadosFornecedor(){
        return new ResponseEntity<>(this.service.listarFornecedor(), HttpStatus.OK);
    }
    
    @DeleteMapping(value = "{id}/deletar-fornecedor")
    @Operation(summary = "Deletar fornecedor")
    public ResponseEntity<FornecedorEntity> excluirFornecedor(@PathVariable Long id){
        FornecedorEntity fornecedorEntity =  this.service.obterFornecedorById(id);
        this.service.excluirFornecedor(fornecedorEntity);
        return new ResponseEntity<>(fornecedorEntity, HttpStatus.OK);
    }

    @PutMapping(value = "{id}/atualizar-fornecedor")
    @Operation(summary = "Atualizar dados fornecedor")
    public ResponseEntity<FornecedorEntity> atualizarFornecedor(
            @PathVariable Long id,
            @Valid
            @RequestBody AtualizarFornecedorRequest atualizarFornecedorRequest){
        FornecedorEntity fornecedorEntity = this.service.obterFornecedorById(id);
        modelMapper.map(atualizarFornecedorRequest,fornecedorEntity);
        fornecedorEntity = this.service.atualizarFornecedor(fornecedorEntity);
        return new ResponseEntity<>(fornecedorEntity, HttpStatus.OK);

    }


}
