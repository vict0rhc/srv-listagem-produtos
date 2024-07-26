package com.example.srv_listagem_produtos.mapper;

import com.example.srv_listagem_produtos.entity.FornecedorEntity;
import com.example.srv_listagem_produtos.model.AtualizarFornecedorRequest;
import com.example.srv_listagem_produtos.model.FornecedorDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FornecedorMapper {

    private final ModelMapper mapper;


    public FornecedorEntity toFornecedor(FornecedorDTO fornecedorDTO){
        return mapper.map(fornecedorDTO,FornecedorEntity.class);

    }

}
